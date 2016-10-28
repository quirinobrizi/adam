/**
 *
 */
package eu.codesketch.adam.docker.command;

import java.util.List;

import com.github.dockerjava.core.command.AbstrDockerCmd;

import eu.codesketch.adam.docker.model.Node;

/**
 * @author quirino
 *
 */
public class NodeCommandImpl extends AbstrDockerCmd<NodeCommand, List<Node>> implements NodeCommand {

    public NodeCommandImpl(NodeCommand.Exec exec) {
        super(exec);
    }

}
