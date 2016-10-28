/**
 *
 */
package eu.codesketch.adam.rest.domain.model.node;

import org.apache.commons.lang3.Validate;

/**
 * V.O. Immutable swarm identifier. <br/>
 *
 * An object that contains attributes but has no conceptual identity. They
 * should be treated as immutable.
 *
 * @author quirino
 *
 */
public class NodeId {

    private final String id;

    private NodeId(String id) {
        Validate.notEmpty(id, "Instance identifier must not be null");
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        NodeId other = (NodeId) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Create an new swarm node identifier
     *
     * @return a new {@link NodeId} instance.
     */
    public static NodeId newInstance(String id) {
        return new NodeId(id);
    }
}
