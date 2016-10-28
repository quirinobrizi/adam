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
