/**
 *
 */
package eu.codesketch.adam.rest.domain.model;

import java.util.UUID;

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
public class SwarmId {

    private final String id;

    private SwarmId(String id) {
        Validate.notEmpty(id, "Swarm identifier must not be null");
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
        SwarmId other = (SwarmId) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Create an new swarm identifier using a random UUID
     *
     * @return a new {@link SwarmId} instance.
     */
    public static SwarmId newSwarmId() {
        return new SwarmId(UUID.randomUUID().toString());
    }

    public static SwarmId from(String swarmId) {
        return new SwarmId(swarmId);
    }
}
