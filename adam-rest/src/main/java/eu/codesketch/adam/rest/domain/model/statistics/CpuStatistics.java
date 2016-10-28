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
package eu.codesketch.adam.rest.domain.model.statistics;

/**
 * @author quirino
 *
 */
public class CpuStatistics {

    private CpuUsage cpuUsage;
    private Long systemCpuUsage;
    private Throttling throttling;

    public CpuStatistics(CpuUsage cpuUsage, Throttling throttling, Long systemCpuUsage) {
        this.cpuUsage = cpuUsage;
        this.throttling = throttling;
        this.systemCpuUsage = systemCpuUsage;
    }

    public CpuUsage getCpuUsage() {
        return cpuUsage;
    }

    public Throttling getThrottling() {
        return throttling;
    }

    public Long getSystemCpuUsage() {
        return systemCpuUsage;
    }
}
