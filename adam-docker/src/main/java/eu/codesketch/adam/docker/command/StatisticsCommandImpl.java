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
package eu.codesketch.adam.docker.command;

import com.github.dockerjava.core.command.AbstrDockerCmd;

import eu.codesketch.adam.docker.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
public class StatisticsCommandImpl extends AbstrDockerCmd<StatisticsCommand, Statistics> implements StatisticsCommand {

    private String containerId;

    public StatisticsCommandImpl(StatisticsCommand.Exec exec, String containerId) {
        super(exec);
        this.containerId = containerId;
    }

    @Override
    public String getContainerId() {
        return this.containerId;
    }

}
