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
 * @author quirino.brizi
 *
 */
@Storable
public class SwarmStorable implements eu.codesketch.adam.rest.infrastructure.repository.model.Storable {

    private static final long serialVersionUID = -3440791229833991096L;

    private String swarmId;
    private String name;
    private Long creationDate;
    private String certificateAuthority;
    private String key;
    private String certificate;
    private NetworkStorable network;
    private RegistryStorable registry;

    public SwarmStorable(String swarmId, String name, Long creationDate, String certificateAuthority, String key,
            String certificate, NetworkStorable network, RegistryStorable registry) {
        this.swarmId = swarmId;
        this.name = name;
        this.creationDate = creationDate;
        this.certificateAuthority = certificateAuthority;
        this.key = key;
        this.certificate = certificate;
        this.network = network;
        this.registry = registry;
    }

    public String getSwarmId() {
        return swarmId;
    }

    public String getName() {
        return name;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public String getCertificateAuthority() {
        return certificateAuthority;
    }

    public String getKey() {
        return key;
    }

    public String getCertificate() {
        return certificate;
    }

    public NetworkStorable getNetwork() {
        return network;
    }

    public RegistryStorable getRegistry() {
        return registry;
    }
}
