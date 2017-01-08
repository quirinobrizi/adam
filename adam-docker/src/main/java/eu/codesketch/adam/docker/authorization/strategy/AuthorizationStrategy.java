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

import eu.codesketch.adam.docker.authorization.AuthorizationContext;

/**
 * @author quirino.brizi
 *
 */
public interface AuthorizationStrategy {

    String authorize(String user, String password, AuthorizationContext authorizationContext);

    boolean supports(AuthorizationType authorizationType);

    public static enum AuthorizationType {
        BASIC("basic"), BEARER("bearer"), NONE("none");

        private String alias;

        private AuthorizationType(String alias) {
            this.alias = alias;
        }

        public static AuthorizationType fromAlias(String alias) {
            for (AuthorizationType authorizationType : values()) {
                if (authorizationType.alias.equalsIgnoreCase(alias)) {
                    return authorizationType;
                }
            }
            throw new IllegalArgumentException(String.format("autorization [%s] is not sipported", alias));
        }
    }
}
