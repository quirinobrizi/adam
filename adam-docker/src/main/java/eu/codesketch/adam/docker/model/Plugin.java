/**
 *
 */
package eu.codesketch.adam.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plugin {

    @JsonProperty("Type")
    private String type;
    @JsonProperty("Name")
    private String name;

    @JsonIgnore
    public String getType() {
        return type;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

}
