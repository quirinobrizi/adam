/**
 *
 */
package eu.codesketch.adam.docker.model.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines {@link Event} severity level.
 *
 * @author quirino
 *
 */
public enum Action {

    // @formatter:off
    ATTACH("attach", "container"),
    COMMIT("commit", "container"),
    COPY("copy", "container"),
    CREATE("create","container"),
    DESTROY("destroy", "container"),
    DETACH("detach", "container"),
    DIE("die", "container"),
    EXEC_CREATE("exec_create", "container"),
    EXEC_DETACH("exec_detach", "container"),
    EXEC_START("exec_start", "container"),
    EXPORT("export", "container"),
    KILL("kill", "container"),
    OOM("oom", "container"),
    PAUSE("pause", "container"),
    RENAME("rename", "container"),
    RESIZE("resize", "container"),
    RESTART("restart", "container"),
    START("start", "container"),
    STOP("stop", "container"),
    TOP("top", "container"),
    UNPAUSE("unpause", "container"),
    UPDATE("update", "container"),
    UNKNOWN("unknown", "unknown"),
    PULL("pull", "container");
    // @formatter:on

    private static final Logger logger = LoggerFactory.getLogger(Action.class);
    private String alias;
    private String source;

    private Action(String alias, String source) {
        this.alias = alias;
        this.source = source;
    }

    public String alias() {
        return this.alias;
    }

    public String getSource() {
        return source;
    }

    public static Action fromAlias(String alias) {
        for (Action level : values()) {
            if (level.alias.equals(alias)) {
                return level;
            }
        }
        logger.info("received unknown action alias [{}]", alias);
        return Action.UNKNOWN;
    }
}
