/**
 *
 */
package eu.codesketch.adam.rest.domain.repository;

import java.util.List;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;

/**
 * Abstract access to docker swarm
 *
 * @author quirino
 *
 */
public interface SwarmRepository {

    /**
     * Add a new Swarm to the swarm collection.
     *
     * @param swarm
     *            the swarm to add.
     */
    void add(Swarm swarm);

    /**
     * Get a {@link Swarm} from the collection, return null if the
     * {@link SwarmId} provided does not identify any {@link Swarm}.
     *
     * @param swarmId
     *            the swarm identifier.
     * @return the swarm identified by the provided identifier or null;
     */
    Swarm get(SwarmId swarmId);

    List<Swarm> getAll();
}
