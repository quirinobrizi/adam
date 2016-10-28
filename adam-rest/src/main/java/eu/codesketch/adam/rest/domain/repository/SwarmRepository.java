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
package eu.codesketch.adam.rest.domain.repository;

import java.util.List;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;

/**
 * Abstract access to docker swarm
 *
 * @author quirino
 *
 */
public interface SwarmRepository {

    /**
     * Add a new Swarm to the swarm collection.
     *
     * @param swarm
     *            the swarm to add.
     */
    void add(Swarm swarm);

    /**
     * Get a {@link Swarm} from the collection, return null if the
     * {@link SwarmId} provided does not identify any {@link Swarm}.
     *
     * @param swarmId
     *            the swarm identifier.
     * @return the swarm identified by the provided identifier or null;
     */
    Swarm get(SwarmId swarmId);

    List<Swarm> getAll();
}
