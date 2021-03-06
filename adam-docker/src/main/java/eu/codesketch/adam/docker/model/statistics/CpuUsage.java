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
