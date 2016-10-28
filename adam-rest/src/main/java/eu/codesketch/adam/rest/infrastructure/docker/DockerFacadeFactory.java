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
package eu.codesketch.adam.rest.infrastructure.docker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

import eu.codesketch.adam.docker.client.SwarmDockerClient;
import eu.codesketch.adam.docker.factory.SwarmDockerExecFactory;
import eu.codesketch.adam.docker.factory.SwarmJerseyDockerCmdExecFactory;
import eu.codesketch.adam.rest.domain.model.Swarm;

/**
 * Generate docker clients
 *
 * @author quirino
 *
 */
@Component
public class DockerFacadeFactory {

    private Map<String, SwarmDockerClient> clients = new HashMap<>();

    public DockerFacade createNewClient(Swarm swarm) {
        String serverUrl = swarm.getServerUrl();
        if (this.clients.containsKey(serverUrl)) {
            return new DockerFacade(this.clients.get(serverUrl));
        }
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost(serverUrl)
                .withDockerTlsVerify(swarm.enableTlsVerify()).withCustomSslConfig(swarm.getSSLConfig()).build();
        SwarmDockerExecFactory dockerCmdExecFactory = new SwarmJerseyDockerCmdExecFactory();
        SwarmDockerClient dockerClient = SwarmDockerClient.getInstance(config).withDockerCmdExecFactory(
                dockerCmdExecFactory);
        this.clients.put(serverUrl, dockerClient);
        return new DockerFacade(dockerClient);
    }

}
