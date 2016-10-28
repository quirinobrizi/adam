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

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino
 *
 */
public class EventMessage implements Message {

    private static final long serialVersionUID = -715803090420490595L;

    @JsonProperty("source")
    private String source;
    @JsonProperty("action")
    private String action;
    @JsonProperty("timestamp")
    private Long timestamp;

    public EventMessage(String source, String action, Long timestamp) {
        this.source = source;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getAction() {
        return action;
    }

    public Long getTimestamp() {
        return timestamp;
    }

}
