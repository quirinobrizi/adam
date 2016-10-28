/**
 *
 */
package eu.codesketch.adam.monitoring.infrastructure.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Context configuration for Adam Monitoring.
 *
 * @author quirino
 *
 */
@Configurable
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = { "eu.codesketch.adam.monitoring" })
public class Application {

}
