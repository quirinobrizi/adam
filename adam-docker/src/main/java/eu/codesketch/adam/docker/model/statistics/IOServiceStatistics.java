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
 * IO Service statistics, results are reported in byte.
 *
 * @author quirino
 *
 */
public class IOServiceStatistics {

    @JsonProperty("major")
    private Integer major;
    @JsonProperty("minor")
    private Integer minor;
    @JsonProperty("op")
    private String operation;
    @JsonProperty("value")
    private Long value;

    @JsonCreator
    public IOServiceStatistics(@JsonProperty("major") Integer major, @JsonProperty("minor") Integer minor,
            @JsonProperty("op") String operation, @JsonProperty("value") Long value) {
        this.major = major;
        this.minor = minor;
        this.operation = operation;
        this.value = value;
    }

    @JsonIgnore
    public Integer getMajor() {
        return major;
    }

    @JsonIgnore
    public Integer getMinor() {
        return minor;
    }

    @JsonIgnore
    public String getOperation() {
        return operation;
    }

    @JsonIgnore
    public Long getValue() {
        return value;
    }
}
