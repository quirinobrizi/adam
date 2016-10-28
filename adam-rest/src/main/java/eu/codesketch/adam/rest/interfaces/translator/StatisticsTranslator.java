/**
 *
 */
package eu.codesketch.adam.rest.interfaces.translator;

import org.springframework.stereotype.Component;

import eu.codesketch.adam.message.swarm.StatisticsMesage;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
@Component
public class StatisticsTranslator {

    public StatisticsMesage translate(Statistics statistics) {
        if (null == statistics) {
            return null;
        }
        return new StatisticsMesage(statistics.getCpuTimePercentage(), statistics.getTotalMemory(),
                statistics.getMemoryUsage(), statistics.getContainers(), statistics.getContainersStopped(),
                statistics.getContainersPaused(), statistics.getContainersRunning(), statistics.getNcpu(),
                statistics.getNumberOfNodes());
    }

}
