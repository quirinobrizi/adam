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

import java.io.IOException;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * @author quirino.brizi
 *
 */
@Provider
public class AuthenticationRequestFilter implements ClientRequestFilter {

    private final AuthorizationProvider authorizationProvider;
    private final Client client;

    public AuthenticationRequestFilter(AuthorizationProvider authorizationProvider, Client client) {
        this.authorizationProvider = authorizationProvider;
        this.client = client;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.client.ClientRequestFilter#filter(javax.ws.rs.client.
     * ClientRequestContext)
     */
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        Optional<String> autorization = authorizationProvider.getAutorization(client, requestContext.getUri());
        if (autorization.isPresent()) {
            headers.putSingle(HttpHeaders.AUTHORIZATION, autorization.get());
        }
    }

}
