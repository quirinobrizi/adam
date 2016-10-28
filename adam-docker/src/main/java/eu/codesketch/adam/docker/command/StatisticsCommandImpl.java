/**
 *
 */
package eu.codesketch.adam.docker.command;

import com.github.dockerjava.core.command.AbstrDockerCmd;

import eu.codesketch.adam.docker.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
public class StatisticsCommandImpl extends AbstrDockerCmd<StatisticsCommand, Statistics> implements StatisticsCommand {

    private String containerId;

    public StatisticsCommandImpl(StatisticsCommand.Exec exec, String containerId) {
        super(exec);
        this.containerId = containerId;
    }

    @Override
    public String getContainerId() {
        return this.containerId;
    }

}
