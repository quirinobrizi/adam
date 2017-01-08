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
public class Statistics {

    private CpuStatistics cpuStatistics;
    private CpuStatistics preCpuStatistics;

    private Long totalMemory;
    private Long memoryUsage;

    private Integer containers;
    private Integer containersStopped;
    private Integer containersPaused;
    private Integer containersRunning;
    private Integer ncpu;
    private Integer numberOfNodes;
    private String serverVersion;
    private Long maxMemoryUsage;
    private Integer failCount;

    public Statistics(CpuStatistics cpuStatistics, CpuStatistics preCpuStatistics, Long totalMemory, Long memoryUsage,
            Long maxMemoryUsage, Integer failCount) {
        this.cpuStatistics = cpuStatistics;
        this.preCpuStatistics = preCpuStatistics;
        this.totalMemory = totalMemory;
        this.memoryUsage = memoryUsage;
        this.maxMemoryUsage = maxMemoryUsage;
        this.failCount = failCount;
        this.ncpu = this.cpuStatistics.getCpuUsage().getNumOfCpus();
    }

    public Statistics(Long totalMemory, Integer containers, Integer containersStopped, Integer containersPaused,
            Integer containersRunning, Integer ncpu, Integer numberOfNodes, String serverVersion) {
        this.totalMemory = totalMemory;
        this.containers = containers;
        this.containersStopped = containersStopped;
        this.containersPaused = containersPaused;
        this.containersRunning = containersRunning;
        this.ncpu = ncpu;
        this.numberOfNodes = numberOfNodes;
        this.serverVersion = serverVersion;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public Integer getContainers() {
        return containers;
    }

    public Integer getContainersPaused() {
        return containersPaused;
    }

    public Integer getContainersRunning() {
        return containersRunning;
    }

    public Integer getContainersStopped() {
        return containersStopped;
    }

    public Integer getNcpu() {
        return ncpu;
    }

    public Long getMemoryUsage() {
        return memoryUsage;
    }

    public Integer getNumberOfNodes() {
        return numberOfNodes;
    }

    public Long getMaxMemoryUsage() {
        return maxMemoryUsage;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public float getCpuTimePercentage() {
        if (null == cpuStatistics || null == preCpuStatistics) {
            return 0.0f;
        }
        Long preTotalCpuUsage = this.preCpuStatistics.getCpuUsage().getTotalUsage();
        Long totalCpuUsage = this.cpuStatistics.getCpuUsage().getTotalUsage();
        Long preSystemCpuUsage = this.preCpuStatistics.getSystemCpuUsage();
        Long systemCpuUsage = this.cpuStatistics.getSystemCpuUsage();

        Long cpuUsageDelta = totalCpuUsage - preTotalCpuUsage;
        Long systemCpuDelta = systemCpuUsage - preSystemCpuUsage;

        float answer = 0.0f;
        if (systemCpuDelta > 0 && cpuUsageDelta > 0) {
            answer = ((float) cpuUsageDelta / (float) systemCpuDelta) * this.cpuStatistics.getCpuUsage().getNumOfCpus()
                    * 100;
        }
        return answer;
    }

    public String getServerVersion() {
        return serverVersion;
    }
}
