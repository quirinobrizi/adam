/**
 *
 */
package eu.codesketch.adam.docker.command;

import com.github.dockerjava.api.command.DockerCmdSyncExec;
import com.github.dockerjava.api.command.SyncDockerCmd;

import eu.codesketch.adam.docker.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
public interface StatisticsCommand extends SyncDockerCmd<Statistics> {

    String getContainerId();

    interface Exec extends DockerCmdSyncExec<StatisticsCommand, Statistics> {
    }
}
