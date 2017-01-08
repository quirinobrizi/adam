/**
 * Copyright [2016-17] [Quirino Brizi (quirino.brizi@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import java.util.ArrayList;
import java.util.List;

import eu.codesketch.adam.rest.domain.model.Image;

/**
 * @author quirino.brizi
 *
 */
public abstract class ImageTranslator {

    public static final Image translate(com.github.dockerjava.api.model.Image image) {
        if (null == image) {
            return null;
        }
        return new Image(image.getCreated(), image.getId(), image.getParentId(), image.getSize(),
                image.getVirtualSize(), image.getRepoTags());
    }

    public static List<eu.codesketch.adam.rest.domain.model.Image> translate(
            List<com.github.dockerjava.api.model.Image> images) {
        if (null == images) {
            return null;
        }
        List<eu.codesketch.adam.rest.domain.model.Image> answer = new ArrayList<Image>();
        for (com.github.dockerjava.api.model.Image image : images) {
            answer.add(translate(image));
        }
        return answer;
    }
}
