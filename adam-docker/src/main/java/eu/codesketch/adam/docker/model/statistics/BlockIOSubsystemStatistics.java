/**
 *
 */
package eu.codesketch.adam.docker.model.statistics;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockIOSubsystemStatistics {

    @JsonProperty("io_service_bytes_recursive")
    private List<IOServiceStatistics> ioServiceBytesRecoursive;
    @JsonProperty("io_serviced_recursive")
    private List<IOServiceStatistics> ioServicedRecursive;
    @JsonProperty("io_queue_recursive")
    private List<IOServiceStatistics> ioQueueRecursive;
    @JsonProperty("io_service_time_recursive")
    private List<IOServiceStatistics> ioServiceTimeRecursive;
    @JsonProperty("io_wait_time_recursive")
    private List<IOServiceStatistics> ioWaitTimeRecursive;
    @JsonProperty("io_merged_recursive")
    private List<IOServiceStatistics> ioMergedRecursive;
    @JsonProperty("io_time_recursive")
    private List<IOServiceStatistics> ioTimeRecursive;
    @JsonProperty("sectors_recursive")
    private List<IOServiceStatistics> sectorsRecursive;

    @JsonIgnore
    public List<IOServiceStatistics> getIoServiceBytesRecoursive() {
        return ioServiceBytesRecoursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoServicedRecursive() {
        return ioServicedRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoQueueRecursive() {
        return ioQueueRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoServiceTimeRecursive() {
        return ioServiceTimeRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoWaitTimeRecursive() {
        return ioWaitTimeRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoMergedRecursive() {
        return ioMergedRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getIoTimeRecursive() {
        return ioTimeRecursive;
    }

    @JsonIgnore
    public List<IOServiceStatistics> getSectorsRecursive() {
        return sectorsRecursive;
    }
}
