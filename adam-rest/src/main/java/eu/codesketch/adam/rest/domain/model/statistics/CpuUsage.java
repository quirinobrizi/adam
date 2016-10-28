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
package eu.codesketch.adam.rest.domain.model.statistics;

import java.util.List;

/**
 *
 * @author quirino
 *
 */
public class CpuUsage {

    private List<Long> perCpuUsage;
    private Long usageInUserMode;
    private Long totalUsage;
    private Long usageInKernelMode;

    public CpuUsage(List<Long> perCpuUsage, Long usageInUserMode, Long totalUsage, Long usageInKernelMode) {
        this.perCpuUsage = perCpuUsage;
        this.usageInUserMode = usageInUserMode;
        this.totalUsage = totalUsage;
        this.usageInKernelMode = usageInKernelMode;
    }

    public List<Long> getPerCpuUsage() {
        return perCpuUsage;
    }

    public Integer getNumOfCpus() {
        if (null == this.perCpuUsage) {
            return 0;
        }
        return this.perCpuUsage.size();
    }

    public Long getUsageInUserMode() {
        return usageInUserMode;
    }

    public Long getTotalUsage() {
        return totalUsage;
    }

    public Long getUsageInKernelMode() {
        return usageInKernelMode;
    }
}
