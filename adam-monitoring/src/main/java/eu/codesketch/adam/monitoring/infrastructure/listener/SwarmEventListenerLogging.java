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
