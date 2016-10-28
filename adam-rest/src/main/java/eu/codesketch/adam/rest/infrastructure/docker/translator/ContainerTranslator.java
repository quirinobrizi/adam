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
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.container.Container.Status;

/**
 * @author quirino
 *
 */
public class ContainerTranslator {

    public static List<Container> translate(List<com.github.dockerjava.api.model.Container> containers) {
        List<Container> answer = new ArrayList<Container>();
        for (com.github.dockerjava.api.model.Container container : containers) {
            ContainerId containerId = ContainerId.newInstance(container.getId());
            List<String> names = Arrays.asList(container.getNames());
            Status status = Container.Status.fromAlias(container.getStatus());
            answer.add(new Container(containerId, names, container.getImage(), container.getCreated(), status));
        }
        return answer;
    }

}
