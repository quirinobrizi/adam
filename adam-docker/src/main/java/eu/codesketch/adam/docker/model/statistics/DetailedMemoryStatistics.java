/**
 *
 */
package eu.codesketch.adam.docker.model.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author quirino
 *
 */
public class DetailedMemoryStatistics {

    @JsonProperty("active_anon")
    private Long activeAnon;
    @JsonProperty("inactive_anon")
    private Long inactiveAnon;
    @JsonProperty("active_file")
    private Long activeFile;
    @JsonProperty("inactive_file")
    private Long inactiveFile;
    @JsonProperty("cache")
    private Long cache;
    @JsonProperty("dirty")
    private Long dirty;
    @JsonProperty("hierarchical_memory_limit")
    private Long hierarchicalMemoryLimit;
    @JsonProperty("mapped_file")
    private Long mappedFile;
    @JsonProperty("pgfault")
    private Long pgFault;
    @JsonProperty("pgmajfault")
    private Long pgMajFault;
    @JsonProperty("pgpgin")
    private Long pgPgIn;
    @JsonProperty("pgpgout")
    private Long pgPgOut;
    @JsonProperty("rss")
    private Long rss;
    @JsonProperty("rss_huge")
    private Long rssHuge;
    @JsonProperty("total_active_anon")
    private Long totalActiveAnon;
    @JsonProperty("total_active_file")
    private Long totalActiveFile;
    @JsonProperty("total_cache")
    private Long totalCache;
    @JsonProperty("total_dirty")
    private Long totalDirty;
    @JsonProperty("total_inactive_anon")
    private Long totalInactiveAnon;
    @JsonProperty("total_inactive_file")
    private Long totalInactiveFile;
    @JsonProperty("total_mapped_file")
    private Long totalMappedFile;
    @JsonProperty("total_pgfault")
    private Long totalPgFault;
    @JsonProperty("total_pgmajfault")
    private Long totalPgMajFault;
    @JsonProperty("total_pgpgin")
    private Long totalPgPgIn;
    @JsonProperty("total_pgpgout")
    private Long totalPgPgOut;
    @JsonProperty("total_rss")
    private Long totalRss;
    @JsonProperty("total_rss_huge")
    private Long totalRssHuge;
    @JsonProperty("total_unevictable")
    private Long totalUnevictable;
    @JsonProperty("total_writeback")
    private Long totalWriteback;
    @JsonProperty("unevictable")
    private Long unevictable;
    @JsonProperty("writeback")
    private Long writeback;

    public Long getActiveAnon() {
        return activeAnon;
    }

    public Long getInactiveAnon() {
        return inactiveAnon;
    }

    public Long getActiveFile() {
        return activeFile;
    }

    public Long getInactiveFile() {
        return inactiveFile;
    }

    public Long getCache() {
        return cache;
    }

    public Long getDirty() {
        return dirty;
    }

    public Long getHierarchicalMemoryLimit() {
        return hierarchicalMemoryLimit;
    }

    public Long getMappedFile() {
        return mappedFile;
    }

    public Long getPgFault() {
        return pgFault;
    }

    public Long getPgMajFault() {
        return pgMajFault;
    }

    public Long getPgPgIn() {
        return pgPgIn;
    }

    public Long getPgPgOut() {
        return pgPgOut;
    }

    public Long getRss() {
        return rss;
    }

    public Long getRssHuge() {
        return rssHuge;
    }

    public Long getTotalActiveAnon() {
        return totalActiveAnon;
    }

    public Long getTotalActiveFile() {
        return totalActiveFile;
    }

    public Long getTotalCache() {
        return totalCache;
    }

    public Long getTotalDirty() {
        return totalDirty;
    }

    public Long getTotalInactiveAnon() {
        return totalInactiveAnon;
    }

    public Long getTotalInactiveFile() {
        return totalInactiveFile;
    }

    public Long getTotalMappedFile() {
        return totalMappedFile;
    }

    public Long getTotalPgFault() {
        return totalPgFault;
    }

    public Long getTotalPgMajFault() {
        return totalPgMajFault;
    }

    public Long getTotalPgPgIn() {
        return totalPgPgIn;
    }

    public Long getTotalPgPgOut() {
        return totalPgPgOut;
    }

    public Long getTotalRss() {
        return totalRss;
    }

    public Long getTotalRssHuge() {
        return totalRssHuge;
    }

    public Long getTotalUnevictable() {
        return totalUnevictable;
    }

    public Long getTotalWriteback() {
        return totalWriteback;
    }

    public Long getUnevictable() {
        return unevictable;
    }

    public Long getWriteback() {
        return writeback;
    }
}
