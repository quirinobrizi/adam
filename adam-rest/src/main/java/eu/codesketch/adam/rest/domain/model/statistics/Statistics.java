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

    public Statistics(CpuStatistics cpuStatistics, CpuStatistics preCpuStatistics, Long totalMemory, Long memoryUsage) {
        this.cpuStatistics = cpuStatistics;
        this.preCpuStatistics = preCpuStatistics;
        this.totalMemory = totalMemory;
        this.memoryUsage = memoryUsage;
        this.ncpu = this.cpuStatistics.getCpuUsage().getNumOfCpus();
    }

    public Statistics(Long totalMemory, Integer containers, Integer containersStopped, Integer containersPaused,
            Integer containersRunning, Integer ncpu, Integer numberOfNodes) {
        this.totalMemory = totalMemory;
        this.containers = containers;
        this.containersStopped = containersStopped;
        this.containersPaused = containersPaused;
        this.containersRunning = containersRunning;
        this.ncpu = ncpu;
        this.numberOfNodes = numberOfNodes;
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
}
