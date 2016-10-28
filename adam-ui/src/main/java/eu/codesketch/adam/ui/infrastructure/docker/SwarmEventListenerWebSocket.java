/**
 *
 */
package eu.codesketch.adam.ui.infrastructure.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import eu.codesketch.adam.docker.event.SwarmEventListener;
import eu.codesketch.adam.docker.model.event.Event;

/**
 * @author quirino
 *
 */
@Component
public class SwarmEventListenerWebSocket implements SwarmEventListener {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /*
     * (non-Javadoc)
     *
     * @see
     * eu.codesketch.adam.docker.event.SwarmEventListener#onEvent(com.accenture
     * .dcsc.adam.docker.model.event.Event)
     */
    @Override
    public void onEvent(Event event) {
        messagingTemplate.convertAndSend("/topic/swarm/events", event);
    }

}
