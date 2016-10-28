/**
 *
 */
package eu.codesketch.adam.docker.event;

import java.util.Set;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.api.model.Event;
import com.github.dockerjava.core.command.EventsResultCallback;

import eu.codesketch.adam.docker.model.event.Action;

/**
 * Default implementation of {@link EventsResultCallback}.
 *
 * @author quirino
 *
 */
public class EventsResultCallbackDefault extends EventsResultCallback {

    private static final Logger logger = LoggerFactory.getLogger(EventsResultCallbackDefault.class);

    private Set<SwarmEventListener> listeners;

    public EventsResultCallbackDefault(Set<SwarmEventListener> listeners) {
        Validate.notEmpty(listeners, "listeners colelction must be provided and must not be empty");
        this.listeners = listeners;
    }

    @Override
    public void onNext(Event item) {
        try {
            eu.codesketch.adam.docker.model.event.Event event = new eu.codesketch.adam.docker.model.event.Event(
                    item.getTime(), item.getFrom(), Action.fromAlias(item.getStatus()));
            for (SwarmEventListener listener : this.listeners) {
                // TODO : QB need to be Async
                listener.onEvent(event);
            }
        } catch (Exception e) {
            logger.error("unable to handle received event {} - {}", item, e.getMessage());
        }
    }

}
