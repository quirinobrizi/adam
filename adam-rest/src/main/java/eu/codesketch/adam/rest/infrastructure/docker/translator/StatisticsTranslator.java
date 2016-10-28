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

import eu.codesketch.adam.docker.model.statistics.Statistics;
import eu.codesketch.adam.rest.domain.model.statistics.CpuStatistics;
import eu.codesketch.adam.rest.domain.model.statistics.CpuUsage;
import eu.codesketch.adam.rest.domain.model.statistics.Throttling;

/**
 * @author quirino
 *
 */
public class StatisticsTranslator {

    public static eu.codesketch.adam.rest.domain.model.statistics.Statistics translate(Statistics statistics) {
        Long totalMemory = statistics.getMemoryStatistics().getLimit();
        Long memoryUsage = statistics.getMemoryStatistics().getUsage();
        return new eu.codesketch.adam.rest.domain.model.statistics.Statistics(
                toCpuUsage(statistics.getCpuStatistics()), toCpuUsage(statistics.getPreCpuStatistics()), totalMemory,
                memoryUsage);
    }

    private static CpuStatistics toCpuUsage(eu.codesketch.adam.docker.model.statistics.CpuStatistics cpuStatistics) {
        eu.codesketch.adam.docker.model.statistics.CpuUsage usage = cpuStatistics.getCpuUsage();
        eu.codesketch.adam.docker.model.statistics.Throttling thrott = cpuStatistics.getThrottling();
        CpuUsage cpuUsage = new CpuUsage(usage.getPerCpuUsage(), usage.getUsageInUserMode(), usage.getTotalUsage(),
                usage.getUsageInKernelMode());
        Throttling throttling = (null != thrott) ? new Throttling(thrott.getPeriods(), thrott.getThrottledPeriods(),
                thrott.getThrottledTime()) : null;
        return new CpuStatistics(cpuUsage, throttling, cpuStatistics.getSystemCpuUsage());
    }
}
