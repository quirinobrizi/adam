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
package eu.codesketch.adam.rest.infrastructure.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.mapdb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.domain.repository.SwarmRepository;
import eu.codesketch.adam.rest.infrastructure.docker.DockerFacadeFactory;
import eu.codesketch.adam.rest.infrastructure.repository.model.SwarmStorable;
import eu.codesketch.adam.rest.infrastructure.repository.translator.SwarmStorableTranslator;

/**
 * Default implementation of {@link SwarmRepository}
 *
 * @author quirino
 *
 */
@Repository
public class SwarmRepositoryDefault implements SwarmRepository {

    // private Map<String, Swarm> swarms = new HashMap<>();

    @Autowired
    private DockerFacadeFactory dockerClientFactory;
    @Autowired
    private DB db;
    @Autowired
    private SwarmStorableTranslator swarmTranslator;

    private ConcurrentMap<String, SwarmStorable> swarms;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        this.swarms = (ConcurrentMap<String, SwarmStorable>) db.hashMap("swarms").createOrOpen();
    }

    /*
     * (non-Javadoc)
     * 
     * @see eu.codesketch.adam.rest.domain.repository.SwarmRepository#add(com
     * .accenture.dcsc.adam.rest.domain.model.Swarm)
     */
    @Override
    public void add(Swarm swarm) {
        SwarmStorable storable = swarmTranslator.translate(swarm);
        swarms.put(swarm.getSwarmId(), storable);
    }

    @Override
    public Swarm get(SwarmId swarmId) {
        SwarmStorable storable = swarms.get(swarmId.toString());
        Swarm swarm = swarmTranslator.translate(storable);
        if (null != swarm && !swarm.hasDockerFacade()) {
            swarm.setDockerClient(dockerClientFactory.createNewClient(swarm));
        }
        return swarm;
    }

    @Override
    public List<Swarm> getAll() {
        List<Swarm> answer = new ArrayList<>();
        Collection<SwarmStorable> storables = swarms.values();
        for (SwarmStorable storable : storables) {
            if (null == storable) {
                continue;
            }
            Swarm swarm = swarmTranslator.translate(storable);
            if (!swarm.hasDockerFacade()) {
                swarm.setDockerClient(dockerClientFactory.createNewClient(swarm));
            }
            answer.add(swarm);
        }
        return answer;
    }

}
