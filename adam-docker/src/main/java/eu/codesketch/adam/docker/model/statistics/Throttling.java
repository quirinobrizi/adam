/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
