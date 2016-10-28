/**
 * 
 */
package eu.codesketch.adam.rest.interfaces.translator;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.rest.domain.model.Network;
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
        return answer;
    }

}
