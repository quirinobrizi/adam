/**
 * 
 */
package eu.codesketch.adam.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Base interface for messages
 * 
 * @author quirino
 *
 */
@JsonInclude(content = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Message extends Serializable {

}
