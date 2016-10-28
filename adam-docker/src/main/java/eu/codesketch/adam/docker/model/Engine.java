/**
 *
 */
package eu.codesketch.adam.docker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Engine {

    @JsonProperty("EngineVersion")
    private String engineVersion;
    @JsonProperty("Labels")
    private Labels labels;
    @JsonProperty("Plugins")
    private List<Plugin> plugins;

    @JsonIgnore
    public String getEngineVersion() {
        return engineVersion;
    }

    @JsonIgnore
    public Labels getLabels() {
        return labels;
    }

    @JsonIgnore
    public List<Plugin> getPlugins() {
        return plugins;
    }
}
