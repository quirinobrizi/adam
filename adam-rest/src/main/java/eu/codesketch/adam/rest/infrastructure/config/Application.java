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
