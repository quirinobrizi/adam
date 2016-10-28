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
public class Specification {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Role")
    private String role;
    @JsonProperty("Availability")
    private String availability;
    @JsonProperty("Labels")
    private Labels labels;

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getRole() {
        return role;
    }

    @JsonIgnore
    public String getAvailability() {
        return availability;
    }

    @JsonIgnore
    public Labels getLabels() {
        return labels;
    }
}
