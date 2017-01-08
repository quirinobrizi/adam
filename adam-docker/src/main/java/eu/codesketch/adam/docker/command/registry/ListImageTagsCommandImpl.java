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

import com.github.dockerjava.api.command.DockerCmdSyncExec;
import com.github.dockerjava.core.command.AbstrDockerCmd;

import eu.codesketch.adam.docker.model.registry.Image;

/**
 * @author quirino.brizi
 *
 */
public class ListImageTagsCommandImpl extends AbstrDockerCmd<ListImageTagsCommand, Image> implements ListImageTagsCommand {

    private String imageName;

    public ListImageTagsCommandImpl(DockerCmdSyncExec<ListImageTagsCommand, Image> execution) {
        super(execution);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.command.registry.ImageCommand#getImageName()
     */
    @Override
    public String getImageName() {
        return imageName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.command.registry.ImageCommand#withImageName(
     * java.lang.String)
     */
    @Override
    public ListImageTagsCommand withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

}
