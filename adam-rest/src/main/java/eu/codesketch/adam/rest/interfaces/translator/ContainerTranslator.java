/**
 *
 */
package eu.codesketch.adam.rest.interfaces.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.ContainerMessage;
import eu.codesketch.adam.rest.domain.model.container.Container;

/**
 * @author quirino
 *
 */
@Component
public class ContainerTranslator {

    public List<ContainerMessage> translate(List<Container> containers) {
        if (null == containers) {
            return null;
        }
        List<ContainerMessage> answer = new ArrayList<>();
        for (Container container : containers) {
            answer.add(new ContainerMessage(container.getContainerId(), container.getNames(), container.getImage(),
                    container.getCreated(), container.getStatus(), null));
        }
        return answer;
    }
}
