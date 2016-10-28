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
