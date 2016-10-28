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
