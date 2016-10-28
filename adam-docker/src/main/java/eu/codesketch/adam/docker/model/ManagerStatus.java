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
public class ManagerStatus {

    @JsonProperty("Leader")
    private Boolean leader;
    @JsonProperty("Reachability")
    private String reachability;
    @JsonProperty("Addr")
    private String address;

    @JsonIgnore
    public Boolean getLeader() {
        return leader;
    }

    @JsonIgnore
    public String getReachability() {
        return reachability;
    }

    @JsonIgnore
    public String getAddress() {
        return address;
    }
}
