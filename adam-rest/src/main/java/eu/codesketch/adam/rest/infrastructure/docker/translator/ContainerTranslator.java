/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.container.Container.Status;

/**
 * @author quirino
 *
 */
public class ContainerTranslator {

    public static List<Container> translate(List<com.github.dockerjava.api.model.Container> containers) {
        List<Container> answer = new ArrayList<Container>();
        for (com.github.dockerjava.api.model.Container container : containers) {
            ContainerId containerId = ContainerId.newInstance(container.getId());
            List<String> names = Arrays.asList(container.getNames());
            Status status = Container.Status.fromAlias(container.getStatus());
            answer.add(new Container(containerId, names, container.getImage(), container.getCreated(), status));
        }
        return answer;
    }

}
