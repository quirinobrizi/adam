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
package eu.codesketch.adam.rest.domain.model.container;

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
public class ContainerId {

    private final String id;

    private ContainerId(String id) {
        Validate.notEmpty(id, "Instance identifier must not be null");
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
        ContainerId other = (ContainerId) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Create an new swarm container identifier
     *
     * @return a new {@link ContainerId} instance.
     */
    public static ContainerId newInstance(String id) {
        return new ContainerId(id);
    }
}
