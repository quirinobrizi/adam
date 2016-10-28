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
public class Node {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("Version")
    private Version version;
    @JsonProperty("CreatedAt")
    private String createdAt;
    @JsonProperty("UpdatedAt")
    private String updatedAt;
    @JsonProperty("Spec")
    private Specification specification;
    @JsonProperty("Description")
    private Description description;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("ManagerStatus")
    private ManagerStatus managerStatus;

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public Version getVersion() {
        return version;
    }

    @JsonIgnore
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public Specification getSpecification() {
        return specification;
    }

    @JsonIgnore
    public Description getDescription() {
        return description;
    }

    @JsonIgnore
    public Status getStatus() {
        return status;
    }

    @JsonIgnore
    public ManagerStatus getManagerStatus() {
        return managerStatus;
    }

}
