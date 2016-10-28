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

    @JsonCreator
    public StatisticsMesage(@JsonProperty("cpuUsage") Float cpuUsage, @JsonProperty("totalMemory") Long totalMemory,
            @JsonProperty("memoryUsage") Long memoryUsage, @JsonProperty("containers") Integer containers,
            @JsonProperty("containersStopped") Integer containersStopped,
            @JsonProperty("containersPaused") Integer containersPaused,
            @JsonProperty("containersRunning") Integer containersRunning, @JsonProperty("ncpu") Integer ncpu,
            @JsonProperty("numberOfNodes") Integer numberOfNodes) {
        this.cpuUsage = cpuUsage;
        this.totalMemory = totalMemory;
        this.memoryUsage = memoryUsage;
        this.containers = containers;
        this.containersStopped = containersStopped;
        this.containersPaused = containersPaused;
        this.containersRunning = containersRunning;
        this.ncpu = ncpu;
        this.numberOfNodes = numberOfNodes;
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
}
