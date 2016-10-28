/**
 *
 */
package eu.codesketch.adam.docker.command;

import java.util.List;

import com.github.dockerjava.api.command.DockerCmdSyncExec;
import com.github.dockerjava.api.command.SyncDockerCmd;

import eu.codesketch.adam.docker.model.Node;

/**
 * @author quirino
 *
 */
public interface NodeCommand extends SyncDockerCmd<List<Node>> {

    interface Exec extends DockerCmdSyncExec<NodeCommand, List<Node>> {
    }
}
