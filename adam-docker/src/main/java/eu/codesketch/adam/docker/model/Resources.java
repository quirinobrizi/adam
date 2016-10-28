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
public class Resources {

    @JsonProperty("NanoCPUs")
    private Long nanoCPUs;
    @JsonProperty("MemoryBytes")
    private Long memoryBytes;

    @JsonIgnore
    public Long getNanoCPUs() {
        return nanoCPUs;
    }

    @JsonIgnore
    public Long getMemoryBytes() {
        return memoryBytes;
    }

}
