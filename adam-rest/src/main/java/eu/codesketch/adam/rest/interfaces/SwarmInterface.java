/**
 *
 */
package eu.codesketch.adam.rest.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import eu.codesketch.adam.message.swarm.ContainerMessage;
import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.message.swarm.StatisticsMesage;
import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.message.swarm.request.CreateSwarmRequestMessage;
import eu.codesketch.adam.message.swarm.response.CreatedSwarmResponseMessage;

/**
 * Swarm interface is responsible for defining the API contract to be used
 * between client and server in a REST style. The interface will be responsible
 * for validating the inputs from the client.
 *
 * @author quirino
 *
 */
@RequestMapping(value = "/swarms", produces = { MediaType.APPLICATION_JSON_VALUE })
public interface SwarmInterface {

    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    CreatedSwarmResponseMessage createNewSwarm(CreateSwarmRequestMessage message);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    List<SwarmMessage> getAllSwarm();

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}", method = RequestMethod.GET)
    SwarmMessage getSwarm(String swarmId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/nodes", method = RequestMethod.GET)
    List<NodeMessage> getSwarmNodes(String swarmId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/containers", method = RequestMethod.GET)
    List<ContainerMessage> getSwarmContainers(String swarmId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/statistics", method = RequestMethod.GET)
    StatisticsMesage getSwarmStatistics(String swarmId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/containers/{containerId}/restart", method = RequestMethod.PUT)
    SwarmMessage restartSwarmContainer(String swarmId, String containerId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/containers/{containerId}/start", method = RequestMethod.PUT)
    SwarmMessage startSwarmContainer(String swarmId, String containerId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/containers/{containerId}/stop", method = RequestMethod.PUT)
    SwarmMessage stopSwarmContainer(String swarmId, String containerId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/containers/{containerId}/statistics", method = RequestMethod.GET)
    StatisticsMesage getSwarmContainerStatistics(String swarmId, String containerId);
}
