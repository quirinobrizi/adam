/**
 *
 */
package eu.codesketch.adam.docker.model.event;

import static org.apache.commons.lang.Validate.notNull;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * V.O. an event originated from the docker subsystem.<br />
 *
 * An object that contains attributes but has no conceptual identity. They
 * should be treated as immutable.
 *
 * @author quirino
 *
 */
public class Event {

    private final Long timestamp;
    private final String source;
    private final Action action;

    public Event(Long timestamp, String source, Action action) {
        notNull(timestamp, "event timestamp must be provided");
        Validate.notEmpty(source, "event source cannot be null");
        Validate.notNull(action, "event action must be provided");

        this.timestamp = timestamp;
        this.source = source;
        this.action = action;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("timestamp", timestamp).append("source", source).append("action", action);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Event other = (Event) obj;
        return new EqualsBuilder().append(this.timestamp, other.timestamp).append(this.source, other.source)
                .append(this.action, other.action).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.timestamp).append(this.source).append(this.action).toHashCode();
    }

}
