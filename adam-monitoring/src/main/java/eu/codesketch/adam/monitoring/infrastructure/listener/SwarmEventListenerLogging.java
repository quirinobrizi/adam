/**
 *
 */
package eu.codesketch.adam.monitoring.infrastructure.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.codesketch.adam.docker.event.SwarmEventListener;
import eu.codesketch.adam.docker.model.event.Event;

/**
 * Swarm event listener which logs the received event.
 *
 * @author quirino
 *
 */
@Component
public class SwarmEventListenerLogging implements SwarmEventListener {

    private static final Logger logger = LoggerFactory.getLogger(SwarmEventListenerLogging.class);

    /*
     * (non-Javadoc)
     *
     * @see
     * eu.codesketch.adam.monitoring.infrastructure.listener.SwarmEventListener
     * #onEvent(eu.codesketch.adam.docker.model.event.Event)
     */
    @Override
    public void onEvent(Event event) {
        logger.info("received event {}", event);
    }

}
