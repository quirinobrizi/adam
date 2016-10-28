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
package eu.codesketch.adam.rest.interfaces.translator;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.StatisticsMesage;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
@Component
public class StatisticsTranslator {

    public StatisticsMesage translate(Statistics statistics) {
        if (null == statistics) {
            return null;
        }
        return new StatisticsMesage(statistics.getCpuTimePercentage(), statistics.getTotalMemory(),
                statistics.getMemoryUsage(), statistics.getContainers(), statistics.getContainersStopped(),
                statistics.getContainersPaused(), statistics.getContainersRunning(), statistics.getNcpu(),
                statistics.getNumberOfNodes());
    }

}
