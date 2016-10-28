/**
 *
 */
package eu.codesketch.adam.rest.domain.model.node;

import org.apache.commons.lang3.StringUtils;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.Version;

/**
 * E. abstract a node part of the swarm cluster.<br/>
 *
 * A node will always be part of a swarm and the access to the instance will
 * always start from a the {@link Swarm} aggregate root.<br/>
 *
 * An object that is not defined by its attributes, but rather by a thread of
 * continuity and its identity.
 *
 * @author quirino
 *
 */
public class Node {

    /**
     * The instance identifier. Once the instance is created the identifier will
     * remain same for the full lifecycle.
     */
    private final NodeId nodeId;
    /**
     * The instance name.
     */
    private String name;
    /**
     * Date the instance has been created
     */
    private final String creationDate;

    private final Version daemonVersion;

    private Node.Status status;
    private Integer runningContainers;

    public Node(NodeId nodeId, String name, String creationDate, Version daemonVersion, Node.Status status,
            Integer runningContainers) {
        this.nodeId = nodeId;
        this.name = name;
        this.creationDate = creationDate;
        this.daemonVersion = daemonVersion;
        this.status = status;
        this.runningContainers = runningContainers;
    }

    public String getNodeId() {
        return this.nodeId.toString();
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getDaemonVersion() {
        return null != daemonVersion ? daemonVersion.get() : null;
    }

    public String getStatus() {
        return status.getAlias();
    }

    public Integer getRunningContainers() {
        return this.runningContainers;
    }

    public static enum Status {
        Healthy("healthy"), Unhealthy("unhealthy");

        private String alias;

        private Status(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }

        public static Node.Status fromAlias(String alias) {
            if (StringUtils.isBlank(alias)) {
                throw new IllegalArgumentException("alias must be provided");
            }
            for (Status status : values()) {
                if (alias.equalsIgnoreCase(status.alias)) {
                    return status;
                }
            }
            return Node.Status.Unhealthy;
        }
    }

}
