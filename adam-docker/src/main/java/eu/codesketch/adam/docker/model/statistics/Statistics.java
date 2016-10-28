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
