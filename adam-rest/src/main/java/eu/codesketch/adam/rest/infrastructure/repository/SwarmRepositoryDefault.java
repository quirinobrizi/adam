/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.codesketch.adam.rest.domain.model.Swarm;
import eu.codesketch.adam.rest.domain.model.SwarmId;
import eu.codesketch.adam.rest.domain.repository.SwarmRepository;
import eu.codesketch.adam.rest.infrastructure.docker.DockerFacadeFactory;

/**
 * Default implementation of {@link SwarmRepository}
 *
 * @author quirino
 *
 */
@Repository
public class SwarmRepositoryDefault implements SwarmRepository {

    private Map<String, Swarm> swarms = new HashMap<>();

    @Autowired
    private DockerFacadeFactory dockerClientFactory;

    /*
     * (non-Javadoc)
     *
     * @see
     * eu.codesketch.adam.rest.domain.repository.SwarmRepository#add(com
     * .accenture.dcsc.adam.rest.domain.model.Swarm)
     */
    @Override
    public void add(Swarm swarm) {
        swarms.put(swarm.getSwarmId(), swarm);
    }

    @Override
    public Swarm get(SwarmId swarmId) {
        Swarm swarm = swarms.get(swarmId.toString());
        if (null != swarm && !swarm.hasDockerFacade()) {
            swarm.setDockerClient(dockerClientFactory.createNewClient(swarm));
        }
        return swarm;
    }

    @Override
    public List<Swarm> getAll() {
        List<Swarm> answer = new ArrayList<>();
        for (Swarm swarm : swarms.values()) {
            if (null == swarm) {
                continue;
            }
            if (!swarm.hasDockerFacade()) {
                swarm.setDockerClient(dockerClientFactory.createNewClient(swarm));
            }
            answer.add(swarm);
        }
        return answer;
    }

}
