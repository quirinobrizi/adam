/**
 *
 */
package eu.codesketch.adam.rest.interfaces.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.rest.domain.model.Swarm;

/**
 * Translate {@link Swarm} model to {@link SwarmMessage} message
 *
 * @author quirino
 *
 */
@Component
public class SwarmTranslator {

    @Autowired
    private StatisticsTranslator statisticsTranslator;

    public SwarmMessage translate(Swarm swarm) {
        SwarmMessage answer = new SwarmMessage(swarm.getSwarmId(), swarm.getName());
        answer.self(String.format("/swarms/%s", swarm.getSwarmId()));
        return answer;
    }

    public List<SwarmMessage> translate(List<Swarm> swarms) {
        if (null == swarms) {
            return null;
        }
        List<SwarmMessage> answer = new ArrayList<>();
        for (Swarm swarm : swarms) {
            answer.add(translate(swarm));
        }
        return answer;
    }

}
