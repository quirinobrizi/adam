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
public class Description {

    @JsonProperty("Hostname")
    private String hostname;
    @JsonProperty("Platform")
    private Platform platform;
    @JsonProperty("Resources")
    private Resources resources;
    @JsonProperty("Engine")
    private Engine engine;

    @JsonIgnore
    public String getHostname() {
        return hostname;
    }

    @JsonIgnore
    public Platform getPlatform() {
        return platform;
    }

    @JsonIgnore
    public Resources getResources() {
        return resources;
    }

    @JsonIgnore
    public Engine getEngine() {
        return engine;
    }

}
