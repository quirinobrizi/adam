/**
 *
 */
package eu.codesketch.adam.rest.domain.model.container;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author quirino
 *
 */
public class Container {

    private ContainerId containerId;
    private List<String> names;
    private String image;
    private Long created;
    private Container.Status status;

    public Container(ContainerId containerId, List<String> names, String image, Long created, Status status) {
        this.containerId = containerId;
        this.names = names;
        this.image = image;
        this.created = created;
        this.status = status;
    }

    public String getContainerId() {
        return containerId.toString();
    }

    public List<String> getNames() {
        return names;
    }

    public String getImage() {
        return image;
    }

    public Long getCreated() {
        return created;
    }

    public String getStatus() {
        return status.getAlias();
    }

    public static enum Status {

        RESTARTING("restarting"), RUNNING("running"), PAUSED("paused"), EXITED("exited"), UNKNOWN("unknown");

        private static final Logger LOGGER = LoggerFactory.getLogger(Container.Status.class);

        private String alias;

        private Status(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }

        public static Container.Status fromAlias(String alias) {
            if (StringUtils.isBlank(alias)) {
                throw new IllegalArgumentException("alias must be provided");
            }
            for (Status status : values()) {
                if (alias.equalsIgnoreCase(status.alias)) {
                    return status;
                }
            }
            if (alias.contains("Up")) {
                return Container.Status.RUNNING;
            }
            if (alias.contains("Exited")) {
                return Container.Status.EXITED;
            }
            LOGGER.info("unknown alias {}", alias);
            return Container.Status.UNKNOWN;
        }
    }
}
