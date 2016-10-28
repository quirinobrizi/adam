/**
 *
 */
package eu.codesketch.adam.monitoring.application;

/**
 * A contract for services responsible for Swarm monitoring.
 *
 * @author quirino
 *
 */
public interface MonitoringService {

    /**
     * Start monitoring activities on all known swarm
     */
    void startMonitoring();
}
