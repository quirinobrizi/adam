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
 * Storable entity
 * 
 * @author quirino.brizi
 *
 */
@Storable
public class NetworkStorable implements eu.codesketch.adam.rest.infrastructure.repository.model.Storable {

    private static final long serialVersionUID = 613248351111460341L;

    private String ipAddress;
    private Integer nodePort;
    private Integer masterPort;

    public NetworkStorable(String ipAddress, Integer nodePort, Integer masterPort) {
        this.ipAddress = ipAddress;
        this.nodePort = nodePort;
        this.masterPort = masterPort;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Integer getNodePort() {
        return nodePort;
    }

    public Integer getMasterPort() {
        return masterPort;
    }
}
