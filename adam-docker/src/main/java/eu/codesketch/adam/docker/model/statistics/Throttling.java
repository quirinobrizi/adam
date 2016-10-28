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
public class Throttling {

    @JsonProperty("periods")
    private Integer periods;
    @JsonProperty("throttled_periods")
    private Integer throttledPeriods;
    @JsonProperty("throttled_time")
    private Integer throttledTime;

    @JsonCreator
    public Throttling(@JsonProperty("periods") Integer periods,
            @JsonProperty("throttled_periods") Integer throttledPeriods,
            @JsonProperty("throttled_time") Integer throttledTime) {
        this.periods = periods;
        this.throttledPeriods = throttledPeriods;
        this.throttledTime = throttledTime;
    }

    @JsonIgnore
    public Integer getPeriods() {
        return periods;
    }

    @JsonIgnore
    public Integer getThrottledPeriods() {
        return throttledPeriods;
    }

    @JsonIgnore
    public Integer getThrottledTime() {
        return throttledTime;
    }
}
