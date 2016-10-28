/**
 *
 */
package eu.codesketch.adam.docker.model.statistics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
public class MemoryStatistics {

    @JsonProperty("usage")
    private Long usage;
    @JsonProperty("max_usage")
    private Long maxUsage;
    @JsonProperty("stats")
    private DetailedMemoryStatistics detailedMemoryStatistics;
    @JsonProperty("failcnt")
    private Integer failCount;
    @JsonProperty("limit")
    private Long limit;

    @JsonCreator
    public MemoryStatistics(@JsonProperty("usage") Long usage, @JsonProperty("max_usage") Long maxUsage,
            @JsonProperty("stats") DetailedMemoryStatistics detailedMemoryStatistics,
            @JsonProperty("failcnt") Integer failCount, @JsonProperty("limit") Long limit) {
        this.usage = usage;
        this.maxUsage = maxUsage;
        this.detailedMemoryStatistics = detailedMemoryStatistics;
        this.failCount = failCount;
        this.limit = limit;
    }

    @JsonIgnore
    public Long getUsage() {
        return usage;
    }

    @JsonIgnore
    public Long getMaxUsage() {
        return maxUsage;
    }

    @JsonIgnore
    public DetailedMemoryStatistics getDetailedMemoryStatistics() {
        return detailedMemoryStatistics;
    }

    @JsonIgnore
    public Integer getFailCount() {
        return failCount;
    }

    @JsonIgnore
    public Long getLimit() {
        return limit;
    }
}
