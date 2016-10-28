/**
 *
 */
package eu.codesketch.adam.monitoring.application;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.dockerjava.core.command.EventsResultCallback;

import eu.codesketch.adam.docker.event.EventsResultCallbackDefault;
import eu.codesketch.adam.docker.event.SwarmEventListener;
import eu.codesketch.adam.rest.application.SwarmService;
import eu.codesketch.adam.rest.domain.model.Swarm;

/**
 * Default implementation for {@link MonitoringService}
 *
 * @author quirino
 *
 */
@Service
public class MonitoringServiceDefault implements MonitoringService {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringServiceDefault.class);
    private static final int DAYS_MS = 2 * 24 * 60 * 60 * 1000;

    @Autowired
    private SwarmService swarmService;
    @Autowired
    private Set<SwarmEventListener> listeners;

    private Map<String, EventsResultCallback> resultCallbacksBySwarm = new HashMap<>();

    @PreDestroy
    public void teardown() {
        for (Entry<String, EventsResultCallback> entry : resultCallbacksBySwarm.entrySet()) {
            try {
                entry.getValue().close();
            } catch (IOException e) {
                logger.error("unable to close event callback for swarm {}", entry.getKey());
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see eu.codesketch.adam.monitoring.application.MonitoringService#
     * startMonitoring()
     */
    @Override
    @Scheduled(initialDelay = 0L, fixedDelay = 10000L)
    public void startMonitoring() {
        List<Swarm> swarms = swarmService.getAllSwarm();
        for (Swarm swarm : swarms) {
            if (!this.resultCallbacksBySwarm.containsKey(swarm.getSwarmId())) {
                EventsResultCallbackDefault eventResultCallback = new EventsResultCallbackDefault(listeners);
                this.resultCallbacksBySwarm.put(swarm.getSwarmId(), eventResultCallback);
                swarm.events(System.currentTimeMillis() - DAYS_MS, eventResultCallback);
            }
        }
    }

}
