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
package eu.codesketch.adam.docker.command;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec;

import eu.codesketch.adam.docker.model.Node;

/**
 * @author quirino
 *
 */
public class NodeCommandExec extends AbstrSyncDockerCmdExec<NodeCommand, List<Node>> implements NodeCommand.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeCommandExec.class);

    public NodeCommandExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec#execute(com.github
     * .dockerjava.api.command.DockerCmd)
     */
    @Override
    protected List<Node> execute(NodeCommand command) {
        WebTarget webResource = getBaseResource().path("/nodes");

        LOGGER.trace("GET: {}", webResource);
        javax.ws.rs.core.GenericType<List<Node>> genericType = new javax.ws.rs.core.GenericType<List<Node>>() {
        };
        return webResource.request().accept(MediaType.APPLICATION_JSON).get(genericType);
    }

}
