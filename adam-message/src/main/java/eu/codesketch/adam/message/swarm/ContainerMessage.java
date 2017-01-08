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
package eu.codesketch.adam.message.swarm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino
 *
 */
public class ContainerMessage implements Message {

    private static final long serialVersionUID = 607966958780202001L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("names")
    private List<String> names;
    @JsonProperty("image")
    private String image;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statistics")
    private StatisticsMessage statistics;

    @JsonCreator
    public ContainerMessage(@JsonProperty("id") String id, @JsonProperty("names") List<String> names,
            @JsonProperty("image") String image, @JsonProperty("created") Long created,
            @JsonProperty("status") String status, @JsonProperty("statistics") StatisticsMessage statistics) {
        this.id = id;
        this.names = names;
        this.image = image;
        this.created = created;
        this.status = status;
        this.statistics = statistics;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public List<String> getNames() {
        return names;
    }

    @JsonIgnore
    public String getImage() {
        return image;
    }

    @JsonIgnore
    public Long getCreated() {
        return created;
    }

    @JsonIgnore
    public String getStatus() {
        return status;
    }

    @JsonIgnore
    public StatisticsMessage getStatistics() {
        return statistics;
    }
}
