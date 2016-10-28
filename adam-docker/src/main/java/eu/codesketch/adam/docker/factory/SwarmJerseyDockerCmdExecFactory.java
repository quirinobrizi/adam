/**
 *
 */
package eu.codesketch.adam.docker.factory;

import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;

import eu.codesketch.adam.docker.command.NodeCommand;
import eu.codesketch.adam.docker.command.NodeCommandExec;
import eu.codesketch.adam.docker.command.StatisticsCommandExec;
import eu.codesketch.adam.docker.command.StatisticsCommand.Exec;

/**
 * @author quirino
 *
 */
public class SwarmJerseyDockerCmdExecFactory extends JerseyDockerCmdExecFactory implements SwarmDockerExecFactory {

    @Override
    public NodeCommand.Exec createNodeCommandExec() {
        return new NodeCommandExec(getBaseResource(), getDockerClientConfig());
    }

    @Override
    public Exec createStatisticsCommandExec() {
        return new StatisticsCommandExec(getBaseResource(), getDockerClientConfig());
    }
}
