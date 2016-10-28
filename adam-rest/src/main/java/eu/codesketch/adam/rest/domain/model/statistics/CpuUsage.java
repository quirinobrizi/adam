package eu.codesketch.adam.rest.domain.model.statistics;

import java.util.List;

/**
 *
 * @author quirino
 *
 */
public class CpuUsage {

    private List<Long> perCpuUsage;
    private Long usageInUserMode;
    private Long totalUsage;
    private Long usageInKernelMode;

    public CpuUsage(List<Long> perCpuUsage, Long usageInUserMode, Long totalUsage, Long usageInKernelMode) {
        this.perCpuUsage = perCpuUsage;
        this.usageInUserMode = usageInUserMode;
        this.totalUsage = totalUsage;
        this.usageInKernelMode = usageInKernelMode;
    }

    public List<Long> getPerCpuUsage() {
        return perCpuUsage;
    }

    public Integer getNumOfCpus() {
        if (null == this.perCpuUsage) {
            return 0;
        }
        return this.perCpuUsage.size();
    }

    public Long getUsageInUserMode() {
        return usageInUserMode;
    }

    public Long getTotalUsage() {
        return totalUsage;
    }

    public Long getUsageInKernelMode() {
        return usageInKernelMode;
    }
}
