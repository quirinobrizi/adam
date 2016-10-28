/**
 *
 */
package eu.codesketch.adam.docker.model.statistics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
public class NetworkStatistics {

    @JsonProperty("rx_bytes")
    private Long rxBytes;
    @JsonProperty("rx_packets")
    private Integer rxPackets;
    @JsonProperty("rx_errors")
    private Integer rxErrors;
    @JsonProperty("rx_dropped")
    private Integer rxDropped;
    @JsonProperty("tx_bytes")
    private Long txBytes;
    @JsonProperty("tx_packets")
    private Integer txPackets;
    @JsonProperty("tx_errors")
    private Integer txErrors;
    @JsonProperty("tx_dropped")
    private Integer txDropped;

    @JsonCreator
    public NetworkStatistics(@JsonProperty("rx_bytes") Long rxBytes, @JsonProperty("rx_packets") Integer rxPackets,
            @JsonProperty("rx_errors") Integer rxErrors, @JsonProperty("rx_dropped") Integer rxDropped,
            @JsonProperty("tx_bytes") Long txBytes, @JsonProperty("tx_packets") Integer txPackets,
            @JsonProperty("tx_errors") Integer txErrors, @JsonProperty("tx_dropped") Integer txDropped) {
        this.rxBytes = rxBytes;
        this.rxPackets = rxPackets;
        this.rxErrors = rxErrors;
        this.rxDropped = rxDropped;
        this.txBytes = txBytes;
        this.txPackets = txPackets;
        this.txErrors = txErrors;
        this.txDropped = txDropped;
    }

    @JsonIgnore
    public Long getRxBytes() {
        return rxBytes;
    }

    @JsonIgnore
    public Integer getRxPackets() {
        return rxPackets;
    }

    @JsonIgnore
    public Integer getRxErrors() {
        return rxErrors;
    }

    @JsonIgnore
    public Integer getRxDropped() {
        return rxDropped;
    }

    @JsonIgnore
    public Long getTxBytes() {
        return txBytes;
    }

    @JsonIgnore
    public Integer getTxPackets() {
        return txPackets;
    }

    @JsonIgnore
    public Integer getTxErrors() {
        return txErrors;
    }

    @JsonIgnore
    public Integer getTxDropped() {
        return txDropped;
    }

}
