/**
 *
 */
package eu.codesketch.adam.rest.interfaces.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.rest.domain.model.node.Node;

/**
 * @author quirino
 *
 */
@Component
public class NodeTranslator {

    public List<NodeMessage> translate(List<Node> nodes) {
        if (null == nodes) {
            return null;
        }
        List<NodeMessage> answer = new ArrayList<>();
        for (Node node : nodes) {
            answer.add(new NodeMessage(node.getNodeId(), node.getName(), node.getDaemonVersion(), node.getStatus(),
                    node.getRunningContainers()));
        }
        return answer;
    }
}
