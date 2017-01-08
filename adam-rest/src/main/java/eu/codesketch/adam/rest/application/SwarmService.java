/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

    Swarm removeContainer(SwarmId swarmId, ContainerId containerId);

    Statistics containerStatistics(SwarmId swarmId, ContainerId containerId);

    List<Node> getNodesOnSwarm(SwarmId swarmId);

    List<Container> getContainersOnSwarm(SwarmId swarmId);

    Statistics getSwarmStatistics(SwarmId swarmId);

}
