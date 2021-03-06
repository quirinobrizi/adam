/**
 * Copyright [2016-17] [Quirino Brizi (quirino.brizi@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.codesketch.adam.docker.command.registry;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec;

import eu.codesketch.adam.docker.model.registry.Image;

/**
 * @author quirino.brizi
 *
 */
public class ListImageTagsCommandExec extends AbstrSyncDockerCmdExec<ListImageTagsCommand, Image> implements ListImageTagsCommand.Exec {

    public ListImageTagsCommandExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Image execute(ListImageTagsCommand command) {
        WebTarget webTarget = getBaseResource().path("{image}/tags/list").resolveTemplate("image",
                command.getImageName());

        return webTarget.request().accept(MediaType.APPLICATION_JSON).get(Image.class);
    }

}
