/**
 *
 */
package eu.codesketch.adam.rest.interfaces.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.docker.model.event.Event;
import eu.codesketch.adam.message.swarm.EventMessage;

/**
 * @author quirino
 *
 */
@Component
public class EventTranslator {

    public List<EventMessage> translate(List<Event> events) {
        if (null == events) {
            return null;
        }
        List<EventMessage> answer = new ArrayList<>();
        for (Event event : events) {
            answer.add(new EventMessage(event.getSource(), event.getAction().alias(), event.getTimestamp()));
        }
        return answer;
    }

}
