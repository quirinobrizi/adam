/**
 *
 */
package eu.codesketch.adam.rest.domain.model.statistics;


/**
 * @author quirino
 *
 */
public class Throttling {

    private Integer periods;
    private Integer throttledPeriods;
    private Integer throttledTime;

    public Throttling(Integer periods, Integer throttledPeriods, Integer throttledTime) {
        this.periods = periods;
        this.throttledPeriods = throttledPeriods;
        this.throttledTime = throttledTime;
    }

    public Integer getPeriods() {
        return periods;
    }

    public Integer getThrottledPeriods() {
        return throttledPeriods;
    }

    public Integer getThrottledTime() {
        return throttledTime;
    }
}
