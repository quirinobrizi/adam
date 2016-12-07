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
package eu.codesketch.adam.message.swarm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino.brizi
 *
 */
public class RegistryMessage implements Message {

    private static final long serialVersionUID = 4942495129320609005L;

    @JsonProperty("url")
    private String url;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String email;

    @JsonCreator
    public RegistryMessage(@JsonProperty("url") String url, @JsonProperty("username") String username,
            @JsonProperty("password") String password, @JsonProperty("email") String email) {
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
