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
public class Platform {

    @JsonProperty("Architecture")
    private String architecture;
    @JsonProperty("OS")
    private String os;

    @JsonIgnore
    public String getArchitecture() {
        return architecture;
    }

    @JsonIgnore
    public String getOs() {
        return os;
    }
}
