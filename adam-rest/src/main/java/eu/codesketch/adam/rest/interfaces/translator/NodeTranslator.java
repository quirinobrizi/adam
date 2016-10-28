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

import eu.codesketch.adam.message.swarm.NodeMessage;
import eu.codesketch.adam.rest.domain.model.node.Node;

/**
 * @author quirino
 *
 */
@Component
public class NodeTranslator {

    public List<NodeMessage> translate(List<Node> nodes) {
        if (null == nodes) {
            return null;
        }
        List<NodeMessage> answer = new ArrayList<>();
        for (Node node : nodes) {
            answer.add(new NodeMessage(node.getNodeId(), node.getName(), node.getDaemonVersion(), node.getStatus(),
                    node.getRunningContainers()));
        }
        return answer;
    }
}
