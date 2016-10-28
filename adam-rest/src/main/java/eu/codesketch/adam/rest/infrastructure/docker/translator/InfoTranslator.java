/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import eu.codesketch.adam.rest.domain.model.info.Info;

/**
 * @author quirino
 *
 */
public class InfoTranslator {

    public static Info translate(com.github.dockerjava.api.model.Info info) {

        // @formatter:off
        return new Info.InfoBuilder()
        .withArchitecture(info.getArchitecture())
        .withContainers(info.getContainers())
        .withContainersStopped(info.getContainersStopped())
        .withContainersPaused(info.getContainersPaused())
        .withContainersRunning(info.getContainersRunning())
        .withImages(info.getImages())
        .withMemTotal(info.getMemTotal())
        .withNcpu(info.getNCPU())
        .build();
        // @formatter:on
    }
}
