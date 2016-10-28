/**
 *
 */
package eu.codesketch.adam.ui.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author quirino
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = { "eu.codesketch.adam.ui" })
@Import({ eu.codesketch.adam.rest.infrastructure.config.Application.class,
    eu.codesketch.adam.monitoring.infrastructure.config.Application.class, WebSocketConfig.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
