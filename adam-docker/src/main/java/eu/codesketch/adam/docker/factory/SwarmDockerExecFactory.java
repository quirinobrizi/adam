/**
 *
 */
package eu.codesketch.adam.docker.factory;

import com.github.dockerjava.api.command.DockerCmdExecFactory;

import eu.codesketch.adam.docker.command.NodeCommand;
import eu.codesketch.adam.docker.command.StatisticsCommand;

/**
 * @author quirino
 *
 */
public interface SwarmDockerExecFactory extends DockerCmdExecFactory {

    NodeCommand.Exec createNodeCommandExec();

    StatisticsCommand.Exec createStatisticsCommandExec();
}
