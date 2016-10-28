/**
 *
 */
package eu.codesketch.adam.docker.command;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec;

import eu.codesketch.adam.docker.model.Node;

/**
 * @author quirino
 *
 */
public class NodeCommandExec extends AbstrSyncDockerCmdExec<NodeCommand, List<Node>> implements NodeCommand.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeCommandExec.class);

    public NodeCommandExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec#execute(com.github
     * .dockerjava.api.command.DockerCmd)
     */
    @Override
    protected List<Node> execute(NodeCommand command) {
        WebTarget webResource = getBaseResource().path("/nodes");

        LOGGER.trace("GET: {}", webResource);
        javax.ws.rs.core.GenericType<List<Node>> genericType = new javax.ws.rs.core.GenericType<List<Node>>() {
        };
        return webResource.request().accept(MediaType.APPLICATION_JSON).get(genericType);
    }

}
