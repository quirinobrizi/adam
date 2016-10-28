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
package eu.codesketch.adam.message.swarm.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;
import eu.codesketch.adam.message.swarm.SwarmMessage;

/**
 * @author quirino
 *
 */
public class CreateSwarmRequestMessage implements Message {

    private static final long serialVersionUID = 5349232705512893474L;

    @JsonProperty("swarm")
    private SwarmMessage swarm;

    @JsonCreator
    public CreateSwarmRequestMessage(@JsonProperty("swarm") SwarmMessage swarm) {
        this.swarm = swarm;
    }

    @JsonIgnore
    public SwarmMessage getSwarm() {
        return swarm;
    }
}
