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
package eu.codesketch.adam.message.swarm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino
 *
 */
public class StatisticsMesage implements Message {

    /**
     *
     */
    private static final long serialVersionUID = -3495211780382474077L;

    @JsonProperty("cpuUsage")
    private Float cpuUsage;
    @JsonProperty("totalMemory")
    private Long totalMemory;
    @JsonProperty("memoryUsage")
    private Long memoryUsage;
    @JsonProperty("containers")
    private Integer containers;
    @JsonProperty("containersStopped")
    private Integer containersStopped;
    @JsonProperty("containersPaused")
    private Integer containersPaused;
    @JsonProperty("containersRunning")
    private Integer containersRunning;
    @JsonProperty("ncpu")
    private Integer ncpu;
    @JsonProperty("numberOfNodes")
    private Integer numberOfNodes;
    @JsonProperty("serverVersion")
    private String serverVersion;
    @JsonProperty("maxMemoryUsage")
    private Long maxMemoryUsage;
    @JsonProperty("failCount")
    private Integer failCount;

    @JsonCreator
    public StatisticsMesage(@JsonProperty("cpuUsage") Float cpuUsage, @JsonProperty("totalMemory") Long totalMemory,
            @JsonProperty("memoryUsage") Long memoryUsage, @JsonProperty("containers") Integer containers,
            @JsonProperty("containersStopped") Integer containersStopped,
            @JsonProperty("containersPaused") Integer containersPaused,
            @JsonProperty("containersRunning") Integer containersRunning, @JsonProperty("ncpu") Integer ncpu,
            @JsonProperty("numberOfNodes") Integer numberOfNodes, @JsonProperty("serverVersion") String serverVersion,
            @JsonProperty("maxMemoryUsage") Long maxMemoryUsage, @JsonProperty("failCount") Integer failCount) {
        this.cpuUsage = cpuUsage;
        this.totalMemory = totalMemory;
        this.memoryUsage = memoryUsage;
        this.containers = containers;
        this.containersStopped = containersStopped;
        this.containersPaused = containersPaused;
        this.containersRunning = containersRunning;
        this.ncpu = ncpu;
        this.numberOfNodes = numberOfNodes;
        this.serverVersion = serverVersion;
        this.maxMemoryUsage = maxMemoryUsage;
        this.failCount = failCount;
    }

    @JsonIgnore
    public Float getCpuUsage() {
        return cpuUsage;
    }

    @JsonIgnore
    public Long getTotalMemory() {
        return totalMemory;
    }

    @JsonIgnore
    public Long getMemoryUsage() {
        return memoryUsage;
    }

    @JsonIgnore
    public Integer getContainers() {
        return containers;
    }

    @JsonIgnore
    public Integer getContainersPaused() {
        return containersPaused;
    }

    @JsonIgnore
    public Integer getContainersRunning() {
        return containersRunning;
    }

    @JsonIgnore
    public Integer getContainersStopped() {
        return containersStopped;
    }

    @JsonIgnore
    public Integer getNcpu() {
        return ncpu;
    }

    @JsonIgnore
    public Integer getNumberOfNodes() {
        return numberOfNodes;
    }

    @JsonIgnore
    public String getServerVersion() {
        return serverVersion;
    }

    @JsonIgnore
    public Long getMaxMemoryUsage() {
        return maxMemoryUsage;
    }

    @JsonIgnore
    public Integer getFailCount() {
        return failCount;
    }
}
