/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
