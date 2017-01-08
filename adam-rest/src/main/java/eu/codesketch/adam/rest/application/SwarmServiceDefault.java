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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;
import eu.codesketch.adam.rest.domain.repository.SwarmRepository;

/**
 * Default implementation for {@link SwarmService}
 *
 * @author quirino
 *
 */
@Service
public class SwarmServiceDefault implements SwarmService {

    @Autowired
    private SwarmRepository swarmRepository;

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.rest.application.SwarmService#createNewSwarm(com.
     * accenture.dcsc.adam.rest.domain.model.Swarm)
     */
    @Override
    public void createNewSwarm(Swarm swarm) {
        swarmRepository.add(swarm);
    }

    @Override
    public Swarm getSwarm(SwarmId swarmId) {
        Swarm swarm = swarmRepository.get(swarmId);
        if (null == swarm) {
            throw new RuntimeException("swarm not found");
        }
        return swarm;
    }

    @Override
    public List<Swarm> getAllSwarm() {
        return swarmRepository.getAll();
    }

    @Override
    public List<Node> getNodesOnSwarm(SwarmId swarmId) {
        Swarm swarm = this.getSwarm(swarmId);
        return swarm.nodes();
    }

    @Override
    public List<Container> getContainersOnSwarm(SwarmId swarmId) {
        Swarm swarm = this.getSwarm(swarmId);
        return swarm.containers();
    }

    @Override
    public Statistics getSwarmStatistics(SwarmId swarmId) {
        Swarm swarm = this.getSwarm(swarmId);
        return swarm.statistics();
    }

    @Override
    public Swarm restartContainer(SwarmId swarmId, ContainerId containerId) {
        Swarm swarm = this.getSwarm(swarmId);
        swarm.restartContainer(containerId);
        return swarm;
    }

    @Override
    public Swarm startContainer(SwarmId swarmId, ContainerId containerId) {
        Swarm swarm = this.getSwarm(swarmId);
        swarm.startContainer(containerId);
        return swarm;
    }

    @Override
    public Swarm stopContainer(SwarmId swarmId, ContainerId containerId) {
        Swarm swarm = this.getSwarm(swarmId);
        swarm.stopContainer(containerId);
        return swarm;
    }

    @Override
    public Swarm removeContainer(SwarmId swarmId, ContainerId containerId) {
        Swarm swarm = this.getSwarm(swarmId);
        swarm.removeContainer(containerId);
        return swarm;
    }

    @Override
    public Statistics containerStatistics(SwarmId swarmId, ContainerId containerId) {
        Swarm swarm = this.getSwarm(swarmId);
        return swarm.containerStatistics(containerId);
    }
}
