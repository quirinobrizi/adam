/**
 *
 */
package eu.codesketch.adam.message.swarm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.Message;

/**
 * @author quirino
 *
 */
public class ContainerMessage implements Message {

    private static final long serialVersionUID = 607966958780202001L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("names")
    private List<String> names;
    @JsonProperty("image")
    private String image;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statistics")
    private StatisticsMesage statistics;

    @JsonCreator
    public ContainerMessage(@JsonProperty("id") String id, @JsonProperty("names") List<String> names,
            @JsonProperty("image") String image, @JsonProperty("created") Long created,
            @JsonProperty("status") String status, @JsonProperty("statistics") StatisticsMesage statistics) {
        this.id = id;
        this.names = names;
        this.image = image;
        this.created = created;
        this.status = status;
        this.statistics = statistics;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public List<String> getNames() {
        return names;
    }

    @JsonIgnore
    public String getImage() {
        return image;
    }

    @JsonIgnore
    public Long getCreated() {
        return created;
    }

    @JsonIgnore
    public String getStatus() {
        return status;
    }

    @JsonIgnore
    public StatisticsMesage getStatistics() {
        return statistics;
    }
}
