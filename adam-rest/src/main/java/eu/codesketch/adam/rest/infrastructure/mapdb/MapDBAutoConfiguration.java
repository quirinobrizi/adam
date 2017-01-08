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
package eu.codesketch.adam.rest.infrastructure.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.DBMaker.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author quirino.brizi
 *
 */
@Configuration
@ConditionalOnClass(DB.class)
@EnableConfigurationProperties(MapDBProperties.class)
// @ConditionalOnProperty(name = "spring.data.mapdb.enabled", havingValue =
// "true")
public class MapDBAutoConfiguration {

    @Autowired
    private MapDBProperties mapDBProperties;

    @Bean(destroyMethod = "close")
    @ConditionalOnMissingBean
    DB db() {
        Maker maker = mapDBProperties.getMemory() ? DBMaker.memoryDirectDB()
                : DBMaker.fileDB(mapDBProperties.getPath()).fileChannelEnable();
        return maker.closeOnJvmShutdown().closeOnJvmShutdown().make();
    }

}
