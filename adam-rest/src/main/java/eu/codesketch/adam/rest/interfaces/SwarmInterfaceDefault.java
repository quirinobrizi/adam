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
import org.springframework.web.bind.annotation.RestController;

import eu.codesketch.adam.message.swarm.ContainerMessage;
import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.message.swarm.StatisticsMesage;
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
import eu.codesketch.adam.rest.interfaces.translator.EventTranslator;
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
    private EventTranslator eventTranslator;
    @Autowired
    private StatisticsTranslator statisticsTranslator;
    @Autowired
    private NodeTranslator nodeTranslator;
    @Autowired
    private ContainerTranslator containerTranslator;

    /*
     * (non-Javadoc)
     *
     * @see
     * eu.codesketch.adam.rest.interfaces.SwarmInterface#createNewSwarm(com
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
     * @see
     * eu.codesketch.adam.rest.interfaces.SwarmInterface#getSwarmNodes(
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
    public StatisticsMesage getSwarmStatistics(@PathVariable("swarmId") String swarmId) {
        Statistics statistics = this.swarmService.getSwarmStatistics(SwarmId.from(swarmId));
        return statisticsTranslator.translate(statistics);
    }

    @Override
    public SwarmMessage restartSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        Swarm swarm = this.swarmService.restartContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return swarmTranslator.translate(swarm);
    }

    @Override
    public SwarmMessage startSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        Swarm swarm = this.swarmService.startContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return swarmTranslator.translate(swarm);
    }

    @Override
    public SwarmMessage stopSwarmContainer(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        Swarm swarm = this.swarmService.stopContainer(SwarmId.from(swarmId), ContainerId.newInstance(containerId));
        return swarmTranslator.translate(swarm);
    }

    @Override
    public StatisticsMesage getSwarmContainerStatistics(@PathVariable("swarmId") @NotNull String swarmId,
            @PathVariable("containerId") @NotNull String containerId) {
        Statistics statistics = this.swarmService.containerStatistics(SwarmId.from(swarmId),
                ContainerId.newInstance(containerId));
        return statisticsTranslator.translate(statistics);
    }

}
