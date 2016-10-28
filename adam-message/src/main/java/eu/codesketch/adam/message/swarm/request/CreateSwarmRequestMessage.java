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
