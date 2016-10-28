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
package eu.codesketch.adam.message.swarm;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.codesketch.adam.message.DiscoverableMessage;

/**
 * A message for exchanging swarm information.
 *
 * @author quirino
 *
 */
public class SwarmMessage implements DiscoverableMessage {

    private static final long serialVersionUID = -7010590032512230435L;

    private String self;

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("nodePort")
    private Integer nodePort;
    @JsonProperty("masterPort")
    private Integer masterPort;
    @JsonProperty("certificateAuthority")
    private String certificateAuthority;
    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("key")
    private String key;
    @JsonProperty("nodes")
    private List<NodeMessage> nodes;
    @JsonProperty("containers")
    private List<ContainerMessage> containers;;

    public SwarmMessage() {
    }

    public SwarmMessage(String id, String name) {
        this(id, name, null, null, null);
    }

    @JsonCreator
    public SwarmMessage(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("certificateAuthority") String certificateAuthority,
            @JsonProperty("certificate") String certificate, @JsonProperty("key") String key) {
        this.id = id;
        this.name = name;
        this.certificateAuthority = certificateAuthority;
        this.certificate = certificate;
        this.key = key;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public String getSelf() {
        return self;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonIgnore
    public Integer getMasterPort() {
        return masterPort;
    }

    @JsonIgnore
    public Integer getNodePort() {
        return nodePort;
    }

    @JsonIgnore
    public String getCertificateAuthority() {
        return certificateAuthority;
    }

    @JsonIgnore
    public String getCertificate() {
        return certificate;
    }

    @JsonIgnore
    public String getKey() {
        return key;
    }

    @JsonIgnore
    public List<NodeMessage> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    @JsonIgnore
    public void setNodes(List<NodeMessage> nodes) {
        this.nodes = nodes;
    }

    @JsonIgnore
    public List<ContainerMessage> getContainers() {
        return containers;
    }

    @JsonIgnore
    public void setContainers(List<ContainerMessage> containers) {
        this.containers = containers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.message.DiscoverableMessage#self()
     */
    @Override
    public String self() {
        return this.self;
    }

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.message.DiscoverableMessage#self(java.lang.
     * String)
     */
    @Override
    public void self(String self) {
        this.self = self;
    }

}
