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
