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
