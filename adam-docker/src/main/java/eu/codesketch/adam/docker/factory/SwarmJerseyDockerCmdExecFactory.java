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
package eu.codesketch.adam.docker.factory;

import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;

import eu.codesketch.adam.docker.command.NodeCommand;
import eu.codesketch.adam.docker.command.NodeCommandExec;
import eu.codesketch.adam.docker.command.StatisticsCommandExec;
import eu.codesketch.adam.docker.command.StatisticsCommand.Exec;

/**
 * @author quirino
 *
 */
public class SwarmJerseyDockerCmdExecFactory extends JerseyDockerCmdExecFactory implements SwarmDockerExecFactory {

    @Override
    public NodeCommand.Exec createNodeCommandExec() {
        return new NodeCommandExec(getBaseResource(), getDockerClientConfig());
    }

    @Override
    public Exec createStatisticsCommandExec() {
        return new StatisticsCommandExec(getBaseResource(), getDockerClientConfig());
    }
}
