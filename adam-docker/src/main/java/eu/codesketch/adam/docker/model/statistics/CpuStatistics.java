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
package eu.codesketch.adam.docker.model.statistics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CpuStatistics {

    @JsonProperty("cpu_usage")
    private CpuUsage cpuUsage;
    @JsonProperty("system_cpu_usage")
    private Long systemCpuUsage;
    @JsonProperty("throttling_data")
    private Throttling throttling;

    @JsonCreator
    public CpuStatistics(@JsonProperty("cpu_usage") CpuUsage cpuUsage, @JsonProperty("throttling") Throttling throttling) {
        this.cpuUsage = cpuUsage;
        this.throttling = throttling;
    }

    @JsonIgnore
    public CpuUsage getCpuUsage() {
        return cpuUsage;
    }

    @JsonIgnore
    public Throttling getThrottling() {
        return throttling;
    }

    @JsonIgnore
    public Long getSystemCpuUsage() {
        return systemCpuUsage;
    }
}
