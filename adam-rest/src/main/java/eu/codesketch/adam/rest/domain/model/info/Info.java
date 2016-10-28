/**
 *
 */
package eu.codesketch.adam.rest.domain.model.info;

import java.util.List;
import java.util.Map;

import com.github.dockerjava.api.model.InfoRegistryConfig;

/**
 * @author quirino
 *
 */
public class Info {

    private String architecture;
    private Integer containers;
    private Integer containersStopped;
    private Integer containersPaused;
    private Integer containersRunning;
    private Boolean cpuCfsPeriod;
    private Boolean cpuCfsQuota;
    private Boolean cpuShares;
    private Boolean cpuSet;
    private Boolean debug;
    private String discoveryBackend;
    private String dockerRootDir;
    private String driver;
    private List<List<String>> driverStatuses;
    private List<Object> systemStatus;
    private Map<String, List<String>> plugins;
    private String executionDriver;
    private String loggingDriver;
    private Boolean experimentalBuild;
    private String httpProxy;
    private String httpsProxy;
    private String id;
    private Boolean ipv4Forwarding;
    private Boolean bridgeNfIptables;
    private Boolean bridgeNfIp6tables;
    private Integer images;
    private String indexServerAddress;
    private String initPath;
    private String initSha1;
    private String kernelVersion;
    private String[] labels;
    private Boolean memoryLimit;
    private Long memTotal;
    private String name;
    private Integer ncpu;
    private Integer nEventsListener;
    private Integer nfd;
    private Integer nGoroutines;
    private String noProxy;
    private Boolean oomKillDisable;
    private String osType;
    private Integer oomScoreAdj;
    private String operatingSystem;
    private InfoRegistryConfig registryConfig;
    private String[] sockets;
    private Boolean swapLimit;
    private String systemTime;
    private String serverVersion;
    private String clusterStore;
    private String clusterAdvertise;

    public Info(String architecture, Integer containers, Integer containersStopped, Integer containersPaused,
            Integer containersRunning, Boolean cpuCfsPeriod, Boolean cpuCfsQuota, Boolean cpuShares, Boolean cpuSet,
            Boolean debug, String discoveryBackend, String dockerRootDir, String driver,
            List<List<String>> driverStatuses, List<Object> systemStatus, Map<String, List<String>> plugins,
            String executionDriver, String loggingDriver, Boolean experimentalBuild, String httpProxy,
            String httpsProxy, String id, Boolean ipv4Forwarding, Boolean bridgeNfIptables, Boolean bridgeNfIp6tables,
            Integer images, String indexServerAddress, String initPath, String initSha1, String kernelVersion,
            String[] labels, Boolean memoryLimit, Long memTotal, String name, Integer ncpu, Integer nEventsListener,
            Integer nfd, Integer nGoroutines, String noProxy, Boolean oomKillDisable, String osType,
            Integer oomScoreAdj, String operatingSystem, InfoRegistryConfig registryConfig, String[] sockets,
            Boolean swapLimit, String systemTime, String serverVersion, String clusterStore, String clusterAdvertise) {
        this.architecture = architecture;
        this.containers = containers;
        this.containersStopped = containersStopped;
        this.containersPaused = containersPaused;
        this.containersRunning = containersRunning;
        this.cpuCfsPeriod = cpuCfsPeriod;
        this.cpuCfsQuota = cpuCfsQuota;
        this.cpuShares = cpuShares;
        this.cpuSet = cpuSet;
        this.debug = debug;
        this.discoveryBackend = discoveryBackend;
        this.dockerRootDir = dockerRootDir;
        this.driver = driver;
        this.driverStatuses = driverStatuses;
        this.systemStatus = systemStatus;
        this.plugins = plugins;
        this.executionDriver = executionDriver;
        this.loggingDriver = loggingDriver;
        this.experimentalBuild = experimentalBuild;
        this.httpProxy = httpProxy;
        this.httpsProxy = httpsProxy;
        this.id = id;
        this.ipv4Forwarding = ipv4Forwarding;
        this.bridgeNfIptables = bridgeNfIptables;
        this.bridgeNfIp6tables = bridgeNfIp6tables;
        this.images = images;
        this.indexServerAddress = indexServerAddress;
        this.initPath = initPath;
        this.initSha1 = initSha1;
        this.kernelVersion = kernelVersion;
        this.labels = labels;
        this.memoryLimit = memoryLimit;
        this.memTotal = memTotal;
        this.name = name;
        this.ncpu = ncpu;
        this.nEventsListener = nEventsListener;
        this.nfd = nfd;
        this.nGoroutines = nGoroutines;
        this.noProxy = noProxy;
        this.oomKillDisable = oomKillDisable;
        this.osType = osType;
        this.oomScoreAdj = oomScoreAdj;
        this.operatingSystem = operatingSystem;
        this.registryConfig = registryConfig;
        this.sockets = sockets;
        this.swapLimit = swapLimit;
        this.systemTime = systemTime;
        this.serverVersion = serverVersion;
        this.clusterStore = clusterStore;
        this.clusterAdvertise = clusterAdvertise;
    }

    public String getArchitecture() {
        return architecture;
    }

    public Integer getContainers() {
        return containers;
    }

    public Integer getContainersStopped() {
        return containersStopped;
    }

    public Integer getContainersPaused() {
        return containersPaused;
    }

    public Integer getContainersRunning() {
        return containersRunning;
    }

    public Boolean getCpuCfsPeriod() {
        return cpuCfsPeriod;
    }

    public Boolean getCpuCfsQuota() {
        return cpuCfsQuota;
    }

    public Boolean getCpuShares() {
        return cpuShares;
    }

    public Boolean getCpuSet() {
        return cpuSet;
    }

    public Boolean getDebug() {
        return debug;
    }

    public String getDiscoveryBackend() {
        return discoveryBackend;
    }

    public String getDockerRootDir() {
        return dockerRootDir;
    }

    public String getDriver() {
        return driver;
    }

    public List<List<String>> getDriverStatuses() {
        return driverStatuses;
    }

    public List<Object> getSystemStatus() {
        return systemStatus;
    }

    public Map<String, List<String>> getPlugins() {
        return plugins;
    }

    public String getExecutionDriver() {
        return executionDriver;
    }

    public String getLoggingDriver() {
        return loggingDriver;
    }

    public Boolean getExperimentalBuild() {
        return experimentalBuild;
    }

    public String getHttpProxy() {
        return httpProxy;
    }

    public String getHttpsProxy() {
        return httpsProxy;
    }

    public String getId() {
        return id;
    }

    public Boolean getIpv4Forwarding() {
        return ipv4Forwarding;
    }

    public Boolean getBridgeNfIptables() {
        return bridgeNfIptables;
    }

    public Boolean getBridgeNfIp6tables() {
        return bridgeNfIp6tables;
    }

    public Integer getImages() {
        return images;
    }

    public String getIndexServerAddress() {
        return indexServerAddress;
    }

    public String getInitPath() {
        return initPath;
    }

    public String getInitSha1() {
        return initSha1;
    }

    public String getKernelVersion() {
        return kernelVersion;
    }

    public String[] getLabels() {
        return labels;
    }

    public Boolean getMemoryLimit() {
        return memoryLimit;
    }

    public Long getMemTotal() {
        return memTotal;
    }

    public String getName() {
        return name;
    }

    public Integer getNcpu() {
        return ncpu;
    }

    public Integer getnEventsListener() {
        return nEventsListener;
    }

    public Integer getNfd() {
        return nfd;
    }

    public Integer getnGoroutines() {
        return nGoroutines;
    }

    public String getNoProxy() {
        return noProxy;
    }

    public Boolean getOomKillDisable() {
        return oomKillDisable;
    }

    public String getOsType() {
        return osType;
    }

    public Integer getOomScoreAdj() {
        return oomScoreAdj;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public InfoRegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public String[] getSockets() {
        return sockets;
    }

    public Boolean getSwapLimit() {
        return swapLimit;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public String getClusterStore() {
        return clusterStore;
    }

    public String getClusterAdvertise() {
        return clusterAdvertise;
    }

    public static class InfoBuilder {
        private String architecture;
        private Integer containers;
        private Integer containersStopped;
        private Integer containersPaused;
        private Integer containersRunning;
        private Boolean cpuCfsPeriod;
        private Boolean cpuCfsQuota;
        private Boolean cpuShares;
        private Boolean cpuSet;
        private Boolean debug;
        private String discoveryBackend;
        private String dockerRootDir;
        private String driver;
        private List<List<String>> driverStatuses;
        private List<Object> systemStatus;
        private Map<String, List<String>> plugins;
        private String executionDriver;
        private String loggingDriver;
        private Boolean experimentalBuild;
        private String httpProxy;
        private String httpsProxy;
        private String id;
        private Boolean ipv4Forwarding;
        private Boolean bridgeNfIptables;
        private Boolean bridgeNfIp6tables;
        private Integer images;
        private String indexServerAddress;
        private String initPath;
        private String initSha1;
        private String kernelVersion;
        private String[] labels;
        private Boolean memoryLimit;
        private Long memTotal;
        private String name;
        private Integer ncpu;
        private Integer nEventsListener;
        private Integer nfd;
        private Integer nGoroutines;
        private String noProxy;
        private Boolean oomKillDisable;
        private String osType;
        private Integer oomScoreAdj;
        private String operatingSystem;
        private InfoRegistryConfig registryConfig;
        private String[] sockets;
        private Boolean swapLimit;
        private String systemTime;
        private String serverVersion;
        private String clusterStore;
        private String clusterAdvertise;

        public InfoBuilder withArchitecture(String architecture) {
            this.architecture = architecture;
            return this;
        }

        public InfoBuilder withContainers(Integer containers) {
            this.containers = containers;
            return this;
        }

        public InfoBuilder withContainersStopped(Integer containersStopped) {
            this.containersStopped = containersStopped;
            return this;
        }

        public InfoBuilder withContainersPaused(Integer containersPaused) {
            this.containersPaused = containersPaused;
            return this;
        }

        public InfoBuilder withContainersRunning(Integer containersRunning) {
            this.containersRunning = containersRunning;
            return this;
        }

        public InfoBuilder withCpuCfsPeriod(Boolean cpuCfsPeriod) {
            this.cpuCfsPeriod = cpuCfsPeriod;
            return this;
        }

        public InfoBuilder withCpuCfsQuota(Boolean cpuCfsQuota) {
            this.cpuCfsQuota = cpuCfsQuota;
            return this;
        }

        public InfoBuilder withCpuShares(Boolean cpuShares) {
            this.cpuShares = cpuShares;
            return this;
        }

        public InfoBuilder withCpuSet(Boolean cpuSet) {
            this.cpuSet = cpuSet;
            return this;
        }

        public InfoBuilder withDebug(Boolean debug) {
            this.debug = debug;
            return this;
        }

        public InfoBuilder withDiscoveryBackend(String discoveryBackend) {
            this.discoveryBackend = discoveryBackend;
            return this;
        }

        public InfoBuilder withDockerRootDir(String dockerRootDir) {
            this.dockerRootDir = dockerRootDir;
            return this;
        }

        public InfoBuilder withDriver(String driver) {
            this.driver = driver;
            return this;
        }

        public InfoBuilder withDriverStatuses(List<List<String>> driverStatuses) {
            this.driverStatuses = driverStatuses;
            return this;
        }

        public InfoBuilder withSystemStatus(List<Object> systemStatus) {
            this.systemStatus = systemStatus;
            return this;
        }

        public InfoBuilder withPlugins(Map<String, List<String>> plugins) {
            this.plugins = plugins;
            return this;
        }

        public InfoBuilder withExecutionDriver(String executionDriver) {
            this.executionDriver = executionDriver;
            return this;
        }

        public InfoBuilder withLoggingDriver(String loggingDriver) {
            this.loggingDriver = loggingDriver;
            return this;
        }

        public InfoBuilder withExperimentalBuild(Boolean experimentalBuild) {
            this.experimentalBuild = experimentalBuild;
            return this;
        }

        public InfoBuilder withHttpProxy(String httpProxy) {
            this.httpProxy = httpProxy;
            return this;
        }

        public InfoBuilder withHttpsProxy(String httpsProxy) {
            this.httpsProxy = httpsProxy;
            return this;
        }

        public InfoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public InfoBuilder withIpv4Forwarding(Boolean ipv4Forwarding) {
            this.ipv4Forwarding = ipv4Forwarding;
            return this;
        }

        public InfoBuilder withBridgeNfIptables(Boolean bridgeNfIptables) {
            this.bridgeNfIptables = bridgeNfIptables;
            return this;
        }

        public InfoBuilder withBridgeNfIp6tables(Boolean bridgeNfIp6tables) {
            this.bridgeNfIp6tables = bridgeNfIp6tables;
            return this;
        }

        public InfoBuilder withImages(Integer images) {
            this.images = images;
            return this;
        }

        public InfoBuilder withIndexServerAddress(String indexServerAddress) {
            this.indexServerAddress = indexServerAddress;
            return this;
        }

        public InfoBuilder withInitPath(String initPath) {
            this.initPath = initPath;
            return this;
        }

        public InfoBuilder withInitSha1(String initSha1) {
            this.initSha1 = initSha1;
            return this;
        }

        public InfoBuilder withKernelVersion(String kernelVersion) {
            this.kernelVersion = kernelVersion;
            return this;
        }

        public InfoBuilder withLabels(String[] labels) {
            this.labels = labels;
            return this;
        }

        public InfoBuilder withMemoryLimit(Boolean memoryLimit) {
            this.memoryLimit = memoryLimit;
            return this;
        }

        public InfoBuilder withMemTotal(Long memTotal) {
            this.memTotal = memTotal;
            return this;
        }

        public InfoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public InfoBuilder withNcpu(Integer ncpu) {
            this.ncpu = ncpu;
            return this;
        }

        public InfoBuilder withNEventsListener(Integer nEventsListener) {
            this.nEventsListener = nEventsListener;
            return this;
        }

        public InfoBuilder withNfd(Integer nfd) {
            this.nfd = nfd;
            return this;
        }

        public InfoBuilder withNGoroutines(Integer nGoroutines) {
            this.nGoroutines = nGoroutines;
            return this;
        }

        public InfoBuilder withNoProxy(String noProxy) {
            this.noProxy = noProxy;
            return this;
        }

        public InfoBuilder withOomKillDisable(Boolean oomKillDisable) {
            this.oomKillDisable = oomKillDisable;
            return this;
        }

        public InfoBuilder withOsType(String osType) {
            this.osType = osType;
            return this;
        }

        public InfoBuilder withOomScoreAdj(Integer oomScoreAdj) {
            this.oomScoreAdj = oomScoreAdj;
            return this;
        }

        public InfoBuilder withOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public InfoBuilder withRegistryConfig(InfoRegistryConfig registryConfig) {
            this.registryConfig = registryConfig;
            return this;
        }

        public InfoBuilder withSockets(String[] sockets) {
            this.sockets = sockets;
            return this;
        }

        public InfoBuilder withSwapLimit(Boolean swapLimit) {
            this.swapLimit = swapLimit;
            return this;
        }

        public InfoBuilder withSystemTime(String systemTime) {
            this.systemTime = systemTime;
            return this;
        }

        public InfoBuilder withServerVersion(String serverVersion) {
            this.serverVersion = serverVersion;
            return this;
        }

        public InfoBuilder withClusterStore(String clusterStore) {
            this.clusterStore = clusterStore;
            return this;
        }

        public InfoBuilder withClusterAdvertise(String clusterAdvertise) {
            this.clusterAdvertise = clusterAdvertise;
            return this;
        }

        public Info build() {
            return new Info(architecture, containers, containersStopped, containersPaused, containersRunning,
                    cpuCfsPeriod, cpuCfsQuota, cpuShares, cpuSet, debug, discoveryBackend, dockerRootDir, driver,
                    driverStatuses, systemStatus, plugins, executionDriver, loggingDriver, experimentalBuild,
                    httpProxy, httpsProxy, id, ipv4Forwarding, bridgeNfIptables, bridgeNfIp6tables, images,
                    indexServerAddress, initPath, initSha1, kernelVersion, labels, memoryLimit, memTotal, name, ncpu,
                    nEventsListener, nfd, nGoroutines, noProxy, oomKillDisable, osType, oomScoreAdj, operatingSystem,
                    registryConfig, sockets, swapLimit, systemTime, serverVersion, clusterStore, clusterAdvertise);
        }
    }

    public static InfoBuilder info() {
        return new InfoBuilder();
    }

}
