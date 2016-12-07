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

import eu.codesketch.adam.message.swarm.SwarmMessage;
import eu.codesketch.adam.rest.domain.model.Swarm;

/**
 * Translate {@link Swarm} model to {@link SwarmMessage} message
 *
 * @author quirino
 *
 */
@Component
public class SwarmTranslator {

    public SwarmMessage translate(Swarm swarm) {
        SwarmMessage answer = new SwarmMessage(swarm.getSwarmId(), swarm.getName());
        answer.self(String.format("/swarms/%s", swarm.getSwarmId()));
        return answer;
    }

    public List<SwarmMessage> translate(List<Swarm> swarms) {
        if (null == swarms) {
            return null;
        }
        List<SwarmMessage> answer = new ArrayList<>();
        for (Swarm swarm : swarms) {
            answer.add(translate(swarm));
        }
        return answer;
    }

}
