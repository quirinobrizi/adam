/**
 *
 */
package eu.codesketch.adam.docker.event;

import eu.codesketch.adam.docker.model.event.Event;

/**
 * Define the contract for concrete Swarm event listener
 * 
 * @author quirino
 *
 */
public interface SwarmEventListener {

    /**
     * Method invoked when a event is generated on a swarm.
     *
     * @param event
     */
    void onEvent(Event event);
}
