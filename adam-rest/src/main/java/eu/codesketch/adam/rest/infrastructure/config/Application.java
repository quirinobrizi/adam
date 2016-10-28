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
package eu.codesketch.adam.rest.infrastructure.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.cache.CacheBuilder;

/**
 * Context configuration for Adam REST.
 *
 * @author quirino
 *
 */
@Configurable
@EnableCaching
@EnableAutoConfiguration
@ComponentScan(basePackages = { "eu.codesketch.adam.rest" })
public class Application {

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager manager = new GuavaCacheManager("nodes", "info", "containers");
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(25);
        manager.setCacheBuilder(builder);
        return manager;
    }
}
