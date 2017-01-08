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

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.docker.authorization.AuthorizationContext;

/**
 * Requests a Bearer token to access docker registry resource.
 * 
 * @author quirino.brizi
 *
 */
public class BearerAuthorizationStrategy implements AuthorizationStrategy {

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy#
     * authorize(java.lang.String, java.lang.String)
     */
    @Override
    public String authorize(String user, String password, AuthorizationContext authorizationContext) {
        Client client = authorizationContext.getClient();
        Builder requestBuilder = client.target(authorizationContext.getRealm())
                .queryParam("service", authorizationContext.getService())
                .queryParam("scope", authorizationContext.getScope()).request(MediaType.APPLICATION_JSON);
        if (StringUtils.isNotBlank(user) && StringUtils.isNotBlank(password)) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, getBasicAuth(user, password));
        }
        TokenResponse tokenResponse = requestBuilder.get(TokenResponse.class);
        return format("Bearer %s", tokenResponse.getToken());
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
        return AuthorizationType.BEARER.equals(authorizationType);
    }

    private String getBasicAuth(String user, String password) {
        String secret = Base64.getEncoder().encodeToString(format("%s:%s", user, password).getBytes());
        return format("Basic %s", secret);
    }

    public static class TokenResponse {

        @JsonProperty("token")
        private String token;

        @JsonIgnore
        public String getToken() {
            return addPaddingIfMissing(token);
        }

        @JsonIgnore
        private String addPaddingIfMissing(String token) {
            if (token.length() % 4 != 0) {
                StringBuilder builder = new StringBuilder(token);
                while (builder.length() % 4 != 0) {
                    builder.append("=");
                }
                return builder.toString();
            }
            return token;
        }
    }
}
