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

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.command.EventsResultCallback;

import eu.codesketch.adam.docker.client.SwarmDockerClient;
import eu.codesketch.adam.docker.client.registry.RegistryClient;
import eu.codesketch.adam.docker.model.statistics.Statistics;
import eu.codesketch.adam.rest.domain.model.Version;
import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.infrastructure.docker.translator.ContainerTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.ImageTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.InfoTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.NodeTranslator;
import eu.codesketch.adam.rest.infrastructure.docker.translator.StatisticsTranslator;

/**
 * @author quirino
 *
 */
public class DockerFacade {

    private SwarmDockerClient dockerClient;
    private final RegistryClient registryClient;

    public DockerFacade(SwarmDockerClient dockerClient, RegistryClient registryClient) {
        this.dockerClient = dockerClient;
        this.registryClient = registryClient;
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

    public void removeContainer(String containerId) {
        this.dockerClient.removeContainerCmd(containerId).exec();
    }

    @Cacheable("statistics")
    public eu.codesketch.adam.rest.domain.model.statistics.Statistics containerStats(String containerId) {
        Statistics statistics = this.dockerClient.statisticsCommand(containerId).exec();
        return StatisticsTranslator.translate(statistics);
    }

    public void events(Long since, EventsResultCallback eventsResultCallback) {
        this.dockerClient.eventsCmd().withSince(Long.toString(since)).exec(eventsResultCallback);
    }

    public eu.codesketch.adam.rest.domain.model.Image getImageByName(String image) {
        List<Image> images = this.dockerClient.listImagesCmd().withImageNameFilter(image).exec();
        return ImageTranslator.translate(images.get(0));
    }

    public List<String> getAvailableImageTags(String imageName) {
        eu.codesketch.adam.docker.model.registry.Image image = this.registryClient.listImageTagsCmd(imageName).exec();
        return image.getTags();
    }

}
