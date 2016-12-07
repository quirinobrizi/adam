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
/**
 * 
 */
package eu.codesketch.adam.rest.interfaces.translator;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.RegistryMessage;
import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.rest.domain.model.Network;
import eu.codesketch.adam.rest.domain.model.Registry;
import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;

/**
 * @author quirino
 *
 */
@Component
public class SwarmMessageTranslator {

    public Swarm translate(SwarmMessage swarm) {
        SwarmId swarmId = SwarmId.newSwarmId();
        Long creationDate = System.currentTimeMillis();
        Network network = new Network(swarm.getIpAddress(), swarm.getNodePort(), swarm.getMasterPort());
        Swarm answer = new Swarm(swarmId, swarm.getName(), creationDate, network);
        answer.setCertificateAuthority(swarm.getCertificateAuthority());
        answer.setCertificate(swarm.getCertificate());
        answer.setKey(swarm.getKey());
        if (null != swarm.getRegistry()) {
            RegistryMessage registry = swarm.getRegistry();
            answer.setRegistry(new Registry(registry.getUrl(), registry.getUsername(), registry.getPassword(),
                    registry.getEmail()));
        }
        return answer;
    }

}
