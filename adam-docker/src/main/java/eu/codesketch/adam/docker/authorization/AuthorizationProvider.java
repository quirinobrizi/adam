/**
 * Copyright [2016-17] [Quirino Brizi (quirino.brizi@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.codesketch.adam.docker.authorization;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;

import com.github.dockerjava.core.DockerClientConfig;

import eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy;
import eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy.AuthorizationType;

/**
 * @author quirino.brizi
 *
 */
public class AuthorizationProvider {

    private final DockerClientConfig dockerClientConfig;

    private final List<AuthorizationStrategy> authorizationStrategies;

    public AuthorizationProvider(final DockerClientConfig dockerClientConfig,
            final List<AuthorizationStrategy> authorizationStrategies) {
        this.dockerClientConfig = dockerClientConfig;
        this.authorizationStrategies = new ArrayList<>(authorizationStrategies);
    }

    public Optional<String> getAutorization(Client client, URI uri) {
        Optional<AuthorizationContext> authorizationDetails = AuthorizationContext.discover(client, uri);
        if (authorizationDetails.isPresent()) {
            return Optional.of(discoverAuthorizationStrategy(authorizationDetails.get()).authorize(
                    dockerClientConfig.getRegistryUsername(), dockerClientConfig.getRegistryPassword(),
                    authorizationDetails.get()));
        }
        return Optional.empty();
    }

    private AuthorizationStrategy discoverAuthorizationStrategy(AuthorizationContext authorizationDetails) {
        AuthorizationType authorizationType = authorizationDetails.getAuthorizationType();
        for (AuthorizationStrategy authorizationStrategy : this.authorizationStrategies) {
            if (authorizationStrategy.supports(authorizationType)) {
                return authorizationStrategy;
            }
        }
        throw new RuntimeException("authorization strategy not found");
    }
}
