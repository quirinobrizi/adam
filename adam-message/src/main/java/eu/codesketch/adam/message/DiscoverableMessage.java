/**
 * 
 */
package eu.codesketch.adam.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A discoverable message
 * 
 * @author quirino
 *
 */
public interface DiscoverableMessage extends Message {

    /**
     * Retrieve reference to this message resource
     * 
     * @return
     */
    @JsonProperty("self")
    String self();

    /**
     * Add reference to this message resource
     * 
     * @param self
     *            the resource locator
     */
    @JsonProperty("self")
    void self(String self);

}
