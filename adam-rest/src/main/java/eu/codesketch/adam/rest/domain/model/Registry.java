/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package eu.codesketch.adam.rest.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * V.O. contain information about the docker registry this swarm is connected
 * too.
 * 
 * @author quirino.brizi
 *
 */
public class Registry {

    private final String url;
    private final String username;
    private final String password;
    private final String email;

    public Registry(String url, String username, String password, String email) {
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

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Registry other = (Registry) obj;
        return new EqualsBuilder().append(this.url, other.url).append(this.username, other.username)
                .append(this.password, other.password).append(this.email, other.email).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.url).append(this.username).append(this.password).append(this.email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Registry [url=" + url + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}
