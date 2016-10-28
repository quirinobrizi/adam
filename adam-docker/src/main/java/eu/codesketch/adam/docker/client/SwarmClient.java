package eu.codesketch.adam.docker.client;

import eu.codesketch.adam.docker.command.NodeCommand;
import eu.codesketch.adam.docker.command.StatisticsCommand;

public interface SwarmClient {

    NodeCommand nodeCommand();

    StatisticsCommand statisticsCommand(String containerId);
}
