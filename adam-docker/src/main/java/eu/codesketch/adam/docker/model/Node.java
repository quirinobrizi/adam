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
