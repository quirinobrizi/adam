/**
 *
 */
package eu.codesketch.adam.rest.application;

import java.util.List;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;

/**
 * Service layer orchestrate logic for Swarm
 *
 * @author quirino
 *
 */
public interface SwarmService {

    /**
     * Create a new {@link Swarm}
     *
     * @param swarm
     */
    void createNewSwarm(Swarm swarm);

    /**
     * Get nodes for the requested {@link Swarm}
     *
     * @param swarmId
     *            the swarm identifier.
     */
    Swarm getSwarm(SwarmId swarmId);

    /**
     * Get a list of all created swarms
     *
     * @return the list of {@link Swarm}
     */
    List<Swarm> getAllSwarm();

    /**
     * Restart a container inside the swarm.
     *
     * @param swarmId
     *            the swarm identifier.
     * @param containerId
     *            the container identifier.
     * @return TODO
     */
    Swarm restartContainer(SwarmId swarmId, ContainerId containerId);

    Swarm startContainer(SwarmId swarmId, ContainerId containerId);

    Swarm stopContainer(SwarmId swarmId, ContainerId containerId);

    Statistics containerStatistics(SwarmId swarmId, ContainerId containerId);

    List<Node> getNodesOnSwarm(SwarmId swarmId);

    List<Container> getContainersOnSwarm(SwarmId swarmId);

    Statistics getSwarmStatistics(SwarmId swarmId);
}
