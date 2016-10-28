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
package eu.codesketch.adam.rest.domain.model;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * V.O. contains networking information for a docker infrastructure component.
 * 
 * @author quirino
 *
 */
public class Network {

    /**
     * The IP address of the swarm component.
     */
    private final String ipAddress;
    /**
     * The TCP port for the swarm node
     */
    private final Integer nodePort;
    /**
     * The TCP port for the swarm master
     */
    private final Integer masterPort;

    public Network(String ipAddress, Integer nodePort) {
        this(ipAddress, nodePort, null);
    }

    public Network(String ipAddress, Integer nodePort, Integer masterPort) {
        Validate.notBlank(ipAddress, "network ip address must be provided");
        Validate.notNull(nodePort, "at least network port for a node must be provided");
        this.ipAddress = ipAddress;
        this.nodePort = nodePort;
        this.masterPort = masterPort;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @return the nodePort
     */
    public Integer getNodePort() {
        return nodePort;
    }

    /**
     * @return the masterPort
     */
    public Integer getMasterPort() {
        return masterPort;
    }

    public String getNodeServerUrl() {
        return String.format("tcp://%s:%d", this.ipAddress, this.nodePort);
    }

    public String getMasterServerUrl() {
        return String.format("tcp://%s:%d", this.ipAddress, this.masterPort);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("ipAddress", ipAddress).append("nodePort", nodePort).append("masterPort", masterPort);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Network other = (Network) obj;
        return new EqualsBuilder().append(this.ipAddress, other.ipAddress).append(this.nodePort, other.nodePort)
                .append(this.masterPort, other.masterPort).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.ipAddress).append(this.nodePort).append(this.masterPort).toHashCode();
    }

}
