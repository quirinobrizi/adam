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

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import eu.codesketch.adam.message.swarm.ContainerMessage;
import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.message.swarm.StatisticsMessage;
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
    StatisticsMessage getSwarmStatistics(String swarmId);

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
    StatisticsMessage getSwarmContainerStatistics(String swarmId, String containerId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/images", method = RequestMethod.GET)
    List<String> getSwarmImages(String swarmId);

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{swarmId}/images/{imageName}", method = RequestMethod.GET)
    List<String> getSwarmImageVersions(String swarmId, String imageName);
}
