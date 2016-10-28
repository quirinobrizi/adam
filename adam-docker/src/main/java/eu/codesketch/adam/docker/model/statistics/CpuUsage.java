/**
 *
 */
package eu.codesketch.adam.docker.model.statistics;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CpuUsage {

    @JsonProperty("percpu_usage")
    private List<Long> perCpuUsage;
    @JsonProperty("usage_in_usermode")
    private Long usageInUserMode;
    @JsonProperty("total_usage")
    private Long totalUsage;
    @JsonProperty("usage_in_kernelmode")
    private Long usageInKernelMode;

    @JsonCreator
    public CpuUsage(@JsonProperty("percpu_usage") List<Long> perCpuUsage,
            @JsonProperty("usage_in_usermode") Long usageInUserMode, @JsonProperty("total_usage") Long totalUsage,
            @JsonProperty("usage_in_kernelmode") Long usageInKernelMode) {
        this.perCpuUsage = perCpuUsage;
        this.usageInUserMode = usageInUserMode;
        this.totalUsage = totalUsage;
        this.usageInKernelMode = usageInKernelMode;
    }

    @JsonIgnore
    public List<Long> getPerCpuUsage() {
        return perCpuUsage;
    }

    @JsonIgnore
    public Integer getNumOfCpus() {
        return this.perCpuUsage.size();
    }

    @JsonIgnore
    public Long getUsageInUserMode() {
        return usageInUserMode;
    }

    @JsonIgnore
    public Long getTotalUsage() {
        return totalUsage;
    }

    @JsonIgnore
    public Long getUsageInKernelMode() {
        return usageInKernelMode;
    }
}
