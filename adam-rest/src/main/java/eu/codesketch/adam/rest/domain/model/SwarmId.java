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

import java.util.UUID;

import org.apache.commons.lang3.Validate;

/**
 * V.O. Immutable swarm identifier. <br/>
 *
 * An object that contains attributes but has no conceptual identity. They
 * should be treated as immutable.
 *
 * @author quirino
 *
 */
public class SwarmId {

    private final String id;

    private SwarmId(String id) {
        Validate.notEmpty(id, "Swarm identifier must not be null");
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
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
        SwarmId other = (SwarmId) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Create an new swarm identifier using a random UUID
     *
     * @return a new {@link SwarmId} instance.
     */
    public static SwarmId newSwarmId() {
        return new SwarmId(UUID.randomUUID().toString());
    }

    public static SwarmId from(String swarmId) {
        return new SwarmId(swarmId);
    }
}
