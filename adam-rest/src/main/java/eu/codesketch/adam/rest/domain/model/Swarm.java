/**
 *
 */
package eu.codesketch.adam.rest.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.github.dockerjava.core.SSLConfig;
import com.github.dockerjava.core.command.EventsResultCallback;

import eu.codesketch.adam.rest.domain.model.container.Container;
import eu.codesketch.adam.rest.domain.model.container.ContainerId;
import eu.codesketch.adam.rest.domain.model.info.Info;
import eu.codesketch.adam.rest.domain.model.node.Node;
import eu.codesketch.adam.rest.domain.model.statistics.Statistics;
import eu.codesketch.adam.rest.infrastructure.SSLHelper;
import eu.codesketch.adam.rest.infrastructure.docker.DockerFacade;

/**
 * A.R. Abstract a docker swarm. This is the architecture aggregate root, access
 * to single parts of the architecture abstraction is made via this aggregate
 * root.<br/>
 *
 * The aggregate root guarantees the consistency of changes being made within
 * the aggregate by forbidding external objects from holding references to its
 * members.
 *
 * @author quirino
 *
 */
public class Swarm {

    /**
     * Internal identifier for a {@link Swarm}. Once created the identifier will
     * remain same for the full lifecycle of a swarm.
     */
    private final SwarmId swarmId;
    /**
     * A human readable identifier for the swarm.
     */
    private String name;
    /**
     * The instances that compose the swarm cluster.
     */
    private final Set<Node> instances;
    /**
     * Date the swarm has been created
     */
    private final Long creationDate;
    /**
     * Events collected from the docker swarm
     */
    private final Set<eu.codesketch.adam.docker.model.event.Event> events;
    /**
     * The networking information for the swarm. those information are taken
     * into account for both swarm master and node as a swarm master is both.
     */
    private final Network network;
    /**
     * The CA used for connecting to the docker daemon
     */
    private String certificateAuthority;
    /**
     * The certificate key used for connecting to the docker daemon
     */
    private String key;
    /**
     * The certificate used for connecting to the docker daemon
     */
    private String certificate;
    /**
     * Client used for connecting to docker daemon
     */
    private DockerFacade dockerFacade;

    public Swarm(SwarmId swarmId, String name, Long creationDate, Network network) {
        Validate.notNull(swarmId, "swarm identifier must be provided");
        Validate.notNull(name, "swarm name must be provided");
        Validate.notNull(creationDate, "swarm creation date must be provided");
        this.swarmId = swarmId;
        this.name = name;
        this.creationDate = creationDate;
        this.network = network;
        this.instances = new HashSet<>();
        this.events = new HashSet<>();
    }

    public String getSwarmId() {
        return this.swarmId.toString();
    }

    public String getName() {
        return name;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void addInstance(Node instance) {
        this.instances.add(instance);
    }

    public void addEvent(eu.codesketch.adam.docker.model.event.Event event) {
        this.events.add(event);
    }

    public String getServerUrl() {
        return this.network.getMasterServerUrl();
    }

    public void setCertificateAuthority(String certificateAuthority) {
        this.certificateAuthority = certificateAuthority;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SSLConfig getSSLConfig() {
        if (StringUtils.isNoneBlank(certificateAuthority, key, certificate)) {
            return SSLHelper.prepareSSLConfig(certificateAuthority, key, certificate);
        }
        return null;
    }

    public boolean enableTlsVerify() {
        return StringUtils.isNoneBlank(certificateAuthority, key, certificate);
    }

    // Swarm interaction methods

    public Version apiVersion() {
        if (hasDockerFacade()) {
            return this.dockerFacade.apiVersion();
        }
        return null;
    }

    public List<Node> nodes() {
        if (hasDockerFacade()) {
            return this.dockerFacade.swarmNodes();
        }
        return null;
    }

    public List<Container> containers() {
        if (hasDockerFacade()) {
            return this.dockerFacade.swarmContainers();
        }
        return null;
    }

    public Statistics statistics() {
        if (hasDockerFacade()) {
            Info info = this.dockerFacade.info();
            List<Node> nodes = nodes();
            return new Statistics(info.getMemTotal(), info.getContainers(), info.getContainersStopped(),
                    info.getContainersPaused(), info.getContainersRunning(), info.getNcpu(), nodes.size());
        }
        return null;
    }

    public void restartContainer(ContainerId containerId) {
        if (hasDockerFacade()) {
            this.dockerFacade.restartContainer(containerId.toString());
        }
    }

    public void startContainer(ContainerId containerId) {
        if (hasDockerFacade()) {
            this.dockerFacade.startContainer(containerId.toString());
        }
    }

    public void stopContainer(ContainerId containerId) {
        if (hasDockerFacade()) {
            this.dockerFacade.stopContainer(containerId.toString());
        }
    }

    public Statistics containerStatistics(ContainerId containerId) {
        if (hasDockerFacade()) {
            return this.dockerFacade.containerStats(containerId.toString());
        }
        return null;
    }

    public void events(Long since, EventsResultCallback eventResultCallback) {
        if (hasDockerFacade()) {
            this.dockerFacade.events(since, eventResultCallback);
        }
    }

    // end swarm interaction method

    public void setDockerClient(DockerFacade dockerFacade) {
        this.dockerFacade = dockerFacade;
    }

    public boolean hasDockerFacade() {
        return null != this.dockerFacade;
    }
}
