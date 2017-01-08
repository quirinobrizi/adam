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
package eu.codesketch.adam.rest.infrastructure.repository.model;

import eu.codesketch.adam.rest.infrastructure.config.Storable;

/**
 * Entity storable for registry
 * 
 * @author quirino.brizi
 *
 */
@Storable
public class RegistryStorable implements eu.codesketch.adam.rest.infrastructure.repository.model.Storable {

    private static final long serialVersionUID = -7709727268626030721L;

    private String url;
    private String username;
    private String password;
    private String email;

    public RegistryStorable(String url, String username, String password, String email) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
