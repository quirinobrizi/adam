/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.api.model.Info;

import eu.codesketch.adam.rest.domain.model.Version;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.domain.model.node.NodeId;

/**
 * @author quirino
 *
 */
public class NodeTranslator {

    public static List<Node> translate(List<eu.codesketch.adam.docker.model.Node> nodes) {
        List<Node> answer = new ArrayList<>();
        for (eu.codesketch.adam.docker.model.Node node : nodes) {
            answer.add(translate(node));
        }
        return answer;
    }

    @SuppressWarnings("unchecked")
    public static List<Node> translate(Info info) {
        List<Node> answer = new ArrayList<>();
        List<Object> systemStatus = info.getSystemStatus();
        for (int i = 0; i < systemStatus.size(); i++) {
            Object object = systemStatus.get(i);
            if (List.class.isAssignableFrom(object.getClass())) {
                List<String> list = (List<String>) object;
                if (list.contains("Nodes")) {
                    int numOfNodes = Integer.parseInt(list.get(1));
                    for (int x = 0; x < numOfNodes; x++) {
                        String name = null;
                        NodeId nodeId = null;
                        Version daemonVersion = null;
                        Node.Status status = Node.Status.Unhealthy;
                        Integer runningContainers = null;
                        for (int j = 0; j <= 8; j++) {
                            i++;
                            List<String> row = (List<String>) systemStatus.get(i);
                            if (j == 0) {
                                name = row.get(0);
                                continue;
                            }
                            if (row.contains("  └ ID")) {
                                nodeId = NodeId.newInstance(row.get(1));
                                continue;
                            }
                            if (row.contains("  └ ServerVersion")) {
                                daemonVersion = new Version(row.get(1));
                            }
                            if (row.contains("  └ Status")) {
                                status = Node.Status.fromAlias(row.get(1));
                            }
                            if (row.contains("  └ Containers")) {
                                String[] rc = row.get(1).split("\\(|\\s");
                                if (rc.length >= 3) {
                                    runningContainers = Integer.parseInt(rc[2]);
                                }
                            }
                        }
                        answer.add(new Node(nodeId, name, null, daemonVersion, status, runningContainers));
                    }
                    break;
                }
            }
        }
        return answer;
    }

    private static Node translate(eu.codesketch.adam.docker.model.Node node) {
        NodeId nodeId = NodeId.newInstance(node.getId());
        Version daemonVersion = new Version(node.getDescription().getEngine().getEngineVersion());
        Node.Status status = Node.Status.fromAlias(node.getStatus().getState());

        return new Node(nodeId, node.getDescription().getHostname(), node.getCreatedAt(), daemonVersion, status, null);
    }
}
