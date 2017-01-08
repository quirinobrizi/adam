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
package eu.codesketch.adam.rest.infrastructure.repository.translator;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.rest.domain.model.Network;
import eu.codesketch.adam.rest.domain.model.Registry;
import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.infrastructure.repository.model.NetworkStorable;
import eu.codesketch.adam.rest.infrastructure.repository.model.RegistryStorable;
import eu.codesketch.adam.rest.infrastructure.repository.model.SwarmStorable;

/**
 * Translate {@link Swarm} to/from {@link SwarmStorable}
 * 
 * @author quirino.brizi
 *
 */
@Component
public class SwarmStorableTranslator {

    /**
     * Translate from {@link Swarm} to {@link SwarmStorable}
     * 
     * @param swarm
     *            the {@link Swarm} to translate
     * @return a {@link SwarmStorable}
     */
    public SwarmStorable translate(Swarm swarm) {
        String swarmId = swarm.getSwarmId();
        String name = swarm.getName();
        Long creationDate = swarm.getCreationDate();
        String certificateAuthority = swarm.getCertificateAuthority();
        String key = swarm.getKey();
        String certificate = swarm.getCertificate();
        NetworkStorable network = new NetworkStorable(swarm.getServerIpAddress(), swarm.getServerNodePort(),
                swarm.getServerMasterPort());
        RegistryStorable registry = new RegistryStorable(swarm.getRegistryUrl(), swarm.getRegistryUsername(),
                swarm.getRegistryPassword(), swarm.getRegistryEmail());
        return new SwarmStorable(swarmId, name, creationDate, certificateAuthority, key, certificate, network,
                registry);
    }

    /**
     * Translate from {@link SwarmStorable} to {@link Swarm}
     * 
     * @param storable
     *            the {@link SwarmStorable} to translate
     * @return a {@link Swarm}
     */
    public Swarm translate(SwarmStorable storable) {
        RegistryStorable registryStorable = storable.getRegistry();
        NetworkStorable networkStorable = storable.getNetwork();
        SwarmId swarmId = SwarmId.from(storable.getSwarmId());
        Long creationDate = System.currentTimeMillis();
        Network network = new Network(networkStorable.getIpAddress(), networkStorable.getNodePort(),
                networkStorable.getMasterPort());
        Swarm answer = new Swarm(swarmId, storable.getName(), creationDate, network);
        answer.setCertificateAuthority(storable.getCertificateAuthority());
        answer.setCertificate(storable.getCertificate());
        answer.setKey(storable.getKey());
        if (null != registryStorable) {
            answer.setRegistry(new Registry(registryStorable.getUrl(), registryStorable.getUsername(),
                    registryStorable.getPassword(), registryStorable.getEmail()));
        }
        return answer;
    }
}
