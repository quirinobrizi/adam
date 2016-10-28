/**
 *
 */
package eu.codesketch.adam.rest.infrastructure.docker.translator;

import eu.codesketch.adam.docker.model.statistics.Statistics;
import eu.codesketch.adam.rest.domain.model.statistics.CpuStatistics;
import eu.codesketch.adam.rest.domain.model.statistics.CpuUsage;
import eu.codesketch.adam.rest.domain.model.statistics.Throttling;

/**
 * @author quirino
 *
 */
public class StatisticsTranslator {

    public static eu.codesketch.adam.rest.domain.model.statistics.Statistics translate(Statistics statistics) {
        Long totalMemory = statistics.getMemoryStatistics().getLimit();
        Long memoryUsage = statistics.getMemoryStatistics().getUsage();
        return new eu.codesketch.adam.rest.domain.model.statistics.Statistics(
                toCpuUsage(statistics.getCpuStatistics()), toCpuUsage(statistics.getPreCpuStatistics()), totalMemory,
                memoryUsage);
    }

    private static CpuStatistics toCpuUsage(eu.codesketch.adam.docker.model.statistics.CpuStatistics cpuStatistics) {
        eu.codesketch.adam.docker.model.statistics.CpuUsage usage = cpuStatistics.getCpuUsage();
        eu.codesketch.adam.docker.model.statistics.Throttling thrott = cpuStatistics.getThrottling();
        CpuUsage cpuUsage = new CpuUsage(usage.getPerCpuUsage(), usage.getUsageInUserMode(), usage.getTotalUsage(),
                usage.getUsageInKernelMode());
        Throttling throttling = (null != thrott) ? new Throttling(thrott.getPeriods(), thrott.getThrottledPeriods(),
                thrott.getThrottledTime()) : null;
        return new CpuStatistics(cpuUsage, throttling, cpuStatistics.getSystemCpuUsage());
    }
}
