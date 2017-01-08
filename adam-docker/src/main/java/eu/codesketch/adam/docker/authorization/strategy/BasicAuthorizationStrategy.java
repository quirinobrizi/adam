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
package eu.codesketch.adam.docker.authorization.strategy;

import static java.lang.String.format;

import java.util.Base64;

import eu.codesketch.adam.docker.authorization.AuthorizationContext;

/**
 * @author quirino.brizi
 *
 */
public class BasicAuthorizationStrategy implements AuthorizationStrategy {

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy#
     * authorize(java.lang.String, java.lang.String)
     */
    @Override
    public String authorize(String user, String password, AuthorizationContext authorizationContext) {
        String secret = Base64.getEncoder().encodeToString(format("%s:%s", user, password).getBytes());
        return format("Basic %s", secret);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy#
     * supports()
     */
    @Override
    public boolean supports(AuthorizationType authorizationType) {
        return AuthorizationType.BASIC.equals(authorizationType);
    }

}
