/**
 *
 */
package eu.codesketch.adam.docker.command;

import static java.lang.String.format;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.AbstrSyncDockerCmdExec;

import eu.codesketch.adam.docker.model.statistics.Statistics;

/**
 * @author quirino
 *
 */
public class StatisticsCommandExec extends AbstrSyncDockerCmdExec<StatisticsCommand, Statistics> implements
        StatisticsCommand.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsCommandExec.class);

    public StatisticsCommandExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
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
    protected Statistics execute(StatisticsCommand command) {
        WebTarget webResource = getBaseResource().path(format("/containers/%s/stats", command.getContainerId()))
                .queryParam("stream", 0);
        LOGGER.trace("GET: {}", webResource);
        javax.ws.rs.core.GenericType<Statistics> genericType = new javax.ws.rs.core.GenericType<Statistics>() {
        };
        return webResource.request().accept(MediaType.APPLICATION_JSON).get(genericType);
    }

}
