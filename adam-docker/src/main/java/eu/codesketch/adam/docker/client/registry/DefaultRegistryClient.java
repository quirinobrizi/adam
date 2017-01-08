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
package eu.codesketch.adam.docker.client.registry;

import com.github.dockerjava.core.DockerClientConfig;

import eu.codesketch.adam.docker.command.registry.ListImageTagsCommand;
import eu.codesketch.adam.docker.command.registry.ListImageTagsCommandImpl;
import eu.codesketch.adam.docker.factory.registry.JerseyDockerRegistryExecFactory;

/**
 * @author quirino.brizi
 *
 */
public class DefaultRegistryClient implements RegistryClient {

    private final DockerClientConfig dockerClientConfig;
    private final JerseyDockerRegistryExecFactory registryCmdExecFactory;

    public DefaultRegistryClient(DockerClientConfig dockerClientConfig) {
        this.dockerClientConfig = dockerClientConfig;
        this.registryCmdExecFactory = new JerseyDockerRegistryExecFactory();
        this.registryCmdExecFactory.init(dockerClientConfig);
    }

    @SuppressWarnings("resource")
    @Override
    public ListImageTagsCommand listImageTagsCmd(String name) {
        return new ListImageTagsCommandImpl(getRegistryCmdExecFactory().listImageTagsCmdExec()).withImageName(name);
    }

    protected JerseyDockerRegistryExecFactory getRegistryCmdExecFactory() {
        return registryCmdExecFactory;
    }

    protected DockerClientConfig getDockerClientConfig() {
        return dockerClientConfig;
    }
}
