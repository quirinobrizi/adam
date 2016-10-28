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
    @JsonProperty("throttling")
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
