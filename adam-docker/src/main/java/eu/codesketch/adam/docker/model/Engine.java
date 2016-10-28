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
package eu.codesketch.adam.docker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Engine {

    @JsonProperty("EngineVersion")
    private String engineVersion;
    @JsonProperty("Labels")
    private Labels labels;
    @JsonProperty("Plugins")
    private List<Plugin> plugins;

    @JsonIgnore
    public String getEngineVersion() {
        return engineVersion;
    }

    @JsonIgnore
    public Labels getLabels() {
        return labels;
    }

    @JsonIgnore
    public List<Plugin> getPlugins() {
        return plugins;
    }
}
