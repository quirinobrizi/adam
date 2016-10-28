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
