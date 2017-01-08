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
package eu.codesketch.adam.rest.interfaces;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.codesketch.adam.message.swarm.ContainerMessage;
import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.message.swarm.StatisticsMessage;
import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.message.swarm.request.CreateSwarmRequestMessage;
import eu.codesketch.adam.message.swarm.response.CreatedSwarmResponseMessage;
import eu.codesketch.adam.rest.application.SwarmService;
import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;
import eu.codesketch.adam.rest.interfaces.translator.ContainerTranslator;
import eu.codesketch.adam.rest.interfaces.translator.NodeTranslator;
import eu.codesketch.adam.rest.interfaces.translator.StatisticsTranslator;
import eu.codesketch.adam.rest.interfaces.translator.SwarmMessageTranslator;
import eu.codesketch.adam.rest.interfaces.translator.SwarmTranslator;

/**
 * Default implementation for {@link SwarmInterface}
 *
 * @author quirino
 *
 */
@RestController
public class SwarmInterfaceDefault implements SwarmInterface {

    @Autowired
    private SwarmService swarmService;
    @Autowired
    private SwarmMessageTranslator swarmMessageTranslator;
    @Autowired
    private SwarmTranslator swarmTranslator;
    @Autowired
    private StatisticsTranslator statisticsTranslator;
    @Autowired
    private NodeTranslator nodeTranslator;
    @Autowired
    private ContainerTranslator containerTranslator;

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.rest.interfaces.SwarmInterface#createNewSwarm(com
     * .accenture.dcsc.adam.message.swarm.request.CreateSwarmRequestMessage)
     */
    @Override
    public CreatedSwarmResponseMessage createNewSwarm(@RequestBody @Valid CreateSwarmRequestMessage message) {
        Swarm swarm = swarmMessageTranslator.translate(message.getSwarm());
        swarmService.createNewSwarm(swarm);
        return new CreatedSwarmResponseMessage(swarmTranslator.translate(swarm));
    }

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.rest.interfaces.SwarmInterface#getSwarmNodes(
     * java.lang.String)
     */
    @Override
    public SwarmMessage getSwarm(@PathVariable("swarmId") @NotNull String swarmId) {
        Swarm swarm = swarmService.getSwarm(SwarmId.from(swarmId));
        return swarmTranslator.translate(swarm);
    }

    @Override
    public List<SwarmMessage> getAllSwarm() {
        List<Swarm> swarms = swarmService.getAllSwarm();
        return swarmTranslator.translate(swarms);
    }

    @Override
    public List<NodeMessage> getSwarmNodes(@PathVariable("swarmId") String swarmId) {
        List<Node> nodes = swarmService.getNodesOnSwarm(SwarmId.from(swarmId));
        return nodeTranslator.translate(nodes);
    }

    @Override
    public List<ContainerMessage> getSwarmContainers(@PathVariable("swarmId") String swarmId) {
        List<Container> containers = swarmService.getContainersOnSwarm(SwarmId.from(swarmId));
        return containerTranslator.translate(containers);
    }

    @Override
    public StatisticsMessage getSwarmStatistics(@PathVariable("swarmId") String swarmId) {
        Statistics statistics = this.swarmService.getSwarmStatistics(SwarmId.from(swarmId));
        return statisticsTranslator.translate(statistics);
    }

    @Override
    public List<ContainerMessage> restartSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        this.swarmService.restartContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return getSwarmContainers(swarmId);
    }

    @Override
    public List<ContainerMessage> startSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        this.swarmService.startContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return getSwarmContainers(swarmId);
    }

    @Override
    public List<ContainerMessage> stopSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        this.swarmService.stopContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return getSwarmContainers(swarmId);
    }

    @Override
    public List<ContainerMessage> removeSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        this.swarmService.removeContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return getSwarmContainers(swarmId);
    }

    @Override
    public StatisticsMessage getSwarmContainerStatistics(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        Statistics statistics = this.swarmService.containerStatistics(SwarmId.from(swarmId),
                ContainerId.newInstance(containerId));
        return statisticsTranslator.translate(statistics);
    }

    @Override
    public List<String> getSwarmImageVersions(@PathVariable("swarmId") @NotNull String swarmId,
            @RequestParam("image") @NotNull String imageName) {
        Swarm swarm = swarmService.getSwarm(SwarmId.from(swarmId));
        return swarm.getImageVersions(imageName);
    }

}
