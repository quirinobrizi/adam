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
        .withServerVersion(info.getServerVersion())
        .build();
        // @formatter:on
    }
}
