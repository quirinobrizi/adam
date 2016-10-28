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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {

    @JsonProperty("read")
    private String read;
    /**
     * The precpu_stats is the cpu statistic of last read, which is used for
     * calculating the cpu usage percent. It is not the exact copy of the
     * “cpu_stats” field.
     */
    @JsonProperty("precpu_stats")
    private CpuStatistics preCpuStatistics;
    @JsonProperty("cpu_stats")
    private CpuStatistics cpuStatistics;
    @JsonProperty("memory_stats")
    private MemoryStatistics memoryStatistics;
    @JsonProperty("blkio_stats")
    private BlockIOSubsystemStatistics blockIOSubsystemStatistics;
    @JsonProperty("networks")
    private Map<String, NetworkStatistics> networks;

    public Statistics(@JsonProperty("read") String read, @JsonProperty("precpu_stats") CpuStatistics preCpuStatistics,
            @JsonProperty("cpu_stats") CpuStatistics cpuStatistics,
            @JsonProperty("memory_stats") MemoryStatistics memoryStatistics,
            @JsonProperty("blkio_stats") BlockIOSubsystemStatistics blockIOSubsystemStatistics,
            @JsonProperty("networks") Map<String, NetworkStatistics> networks) {
        this.read = read;
        this.preCpuStatistics = preCpuStatistics;
        this.cpuStatistics = cpuStatistics;
        this.memoryStatistics = memoryStatistics;
        this.blockIOSubsystemStatistics = blockIOSubsystemStatistics;
        this.networks = networks;
    }

    public String getRead() {
        return read;
    }

    public CpuStatistics getPreCpuStatistics() {
        return preCpuStatistics;
    }

    public CpuStatistics getCpuStatistics() {
        return cpuStatistics;
    }

    public MemoryStatistics getMemoryStatistics() {
        return memoryStatistics;
    }

    public BlockIOSubsystemStatistics getBlockIOSubsystemStatistics() {
        return blockIOSubsystemStatistics;
    }

    public Map<String, NetworkStatistics> getNetworks() {
        return networks;
    }
}
