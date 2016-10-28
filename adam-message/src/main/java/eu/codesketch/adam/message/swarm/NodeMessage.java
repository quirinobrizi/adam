/**
 *
 */
package eu.codesketch.adam.message.swarm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino
 *
 */
public class NodeMessage implements Message {

    private static final long serialVersionUID = 2703418363432827173L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("daemonVersion")
    private String daemonVersion;
    @JsonProperty("status")
    private String status;
    @JsonProperty("runningContainers")
    private Integer runningContainers;

    @JsonCreator
    public NodeMessage(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("daemonVersion") String daemonVersion, @JsonProperty("status") String status,
            @JsonProperty("runningContainers") Integer runningContainers) {
        super();
        this.id = id;
        this.name = name;
        this.daemonVersion = daemonVersion;
        this.status = status;
        this.runningContainers = runningContainers;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getDaemonVersion() {
        return daemonVersion;
    }

    @JsonIgnore
    public String getStatus() {
        return status;
    }

    @JsonIgnore
    public Integer getRunningContainers() {
        return runningContainers;
    }

}
