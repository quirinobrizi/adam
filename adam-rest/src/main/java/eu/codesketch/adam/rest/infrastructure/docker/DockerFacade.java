/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.docker;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.command.EventsResultCallback;

import eu.codesketch.adam.docker.client.SwarmDockerClient;
import eu.codesketch.adam.docker.model.statistics.Statistics;
import eu.codesketch.adam.rest.domain.model.Version;
import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.infrastructure.docker.translator.ContainerTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.InfoTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.NodeTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.StatisticsTranslator;

/**
 * @author quirino
 *
 */
public class DockerFacade {

    private SwarmDockerClient dockerClient;

    public DockerFacade(SwarmDockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public Version apiVersion() {
        return new Version(this.dockerClient.versionCmd().exec().getApiVersion());
    }

    @Cacheable(value = "info")
    public eu.codesketch.adam.rest.domain.model.info.Info info() {
        Info info = this.dockerClient.infoCmd().exec();
        return InfoTranslator.translate(info);
    }

    /**
     * Retrieve docker swarm nodes
     *
     * @return the nodes connected to a docker swarm.
     */
    @Cacheable(value = "nodes")
    public List<Node> swarmNodes() {
        if (apiVersion().isHigherThanOrEqualTo(new Version("1.24"))) {
            // nodes endpoint is available
            List<eu.codesketch.adam.docker.model.Node> nodes = this.dockerClient.nodeCommand().exec();
            return NodeTranslator.translate(nodes);
        } else {
            // nodes endpoint is not available
            Info info = this.dockerClient.infoCmd().exec();
            return NodeTranslator.translate(info);
        }
    }

    @Cacheable(value = "containers")
    public List<Container> swarmContainers() {
        List<com.github.dockerjava.api.model.Container> containers = this.dockerClient.listContainersCmd()
                .withShowAll(true).exec();
        return ContainerTranslator.translate(containers);
    }

    public void restartContainer(String containerId) {
        this.dockerClient.restartContainerCmd(containerId).exec();
    }

    public void startContainer(String containerId) {
        this.dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        this.dockerClient.stopContainerCmd(containerId).exec();
    }

    @Cacheable
    public eu.codesketch.adam.rest.domain.model.statistics.Statistics containerStats(String containerId) {
        Statistics statistics = this.dockerClient.statisticsCommand(containerId).exec();
        return StatisticsTranslator.translate(statistics);
    }

    public void events(Long since, EventsResultCallback eventsResultCallback) {
        this.dockerClient.eventsCmd().withSince(Long.toString(since)).exec(eventsResultCallback);
    }
}
