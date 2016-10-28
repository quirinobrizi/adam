/**
 * 
 */
package eu.codesketch.adam.message.swarm.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;
import eu.codesketch.adam.message.swarm.SwarmMessage;

/**
 * Response message for created swarm
 * 
 * @author quirino
 *
 */
public class CreatedSwarmResponseMessage implements Message {

    private static final long serialVersionUID = -4934467786782015847L;

    @JsonProperty("swarm")
    private SwarmMessage swarm;

    @JsonCreator
    public CreatedSwarmResponseMessage(@JsonProperty("swarm") SwarmMessage swarm) {
        this.swarm = swarm;
    }
}
