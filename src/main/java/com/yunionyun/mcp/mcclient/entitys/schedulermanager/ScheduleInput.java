package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class ScheduleInput {
    @JSONField(name = "best_effort")
    private boolean bestEffort;

    @JSONField(name = "suggestion_limit")
    private long suggestionLimit;

    @JSONField(name = "suggestion_all")
    private boolean suggestionAll;

    @JSONField(name = "ignore_filters")
    private String[] ignoreFilters;

    @JSONField(name = "session_id")
    private String sessionId;

    @JSONField(name = "details")
    private boolean details;

    @JSONField(name = "prefer_region_id")
    private String preferRegion;

    @JSONField(name = "prefer_zone_id")
    private String preferZone;

    @JSONField(name = "prefer_wire_id")
    private String preferWire;

    @JSONField(name = "prefer_host_id")
    private String preferHost;

    @JSONField(name = "prefer_backup_host")
    private String preferBackupHost;

    @JSONField(name = "hypervisor")
    private String hypervisor;

    @JSONField(name = "resource_type")
    private String resourceType;

    @JSONField(name = "instance_type")
    private String instanceType;

    @JSONField(name = "sku")
    private String sku;

    @JSONField(name = "backup")
    private boolean backup;

    @JSONField(name = "count")
    private int count;

    @JSONField(name = "disks")
    private DiskConfig[] disks;

    @JSONField(name = "schedtags")
    private SchedtagConfig[] schedtags;

    @JSONField(name = "isolated_devices")
    private IsolatedDeviceConfig[] isolatedDevices;

    @JSONField(name = "baremetal_disk_configs")
    private BaremetalDiskConfig[] baremetalDiskConfigs;

    @JSONField(name = "groups")
    private String[] instanceGroupIds;

    @JSONField(name = "suggestion")
    private boolean suggestion;

    @JSONField(name = "host_id")
    private String hostId;

    @JSONField(name = "live_migrate")
    private boolean liveMigrate;

    @JSONField(name = "cpu_desc")
    private String cpuDesc;

    @JSONField(name = "cpu_microcode")
    private String cpuMicrocode;

    private JSONObject[] pendingUsages;

    public boolean isBestEffort() {
        return bestEffort;
    }

    public void setBestEffort(boolean bestEffort) {
        this.bestEffort = bestEffort;
    }

    public long getSuggestionLimit() {
        return suggestionLimit;
    }

    public void setSuggestionLimit(long suggestionLimit) {
        this.suggestionLimit = suggestionLimit;
    }

    public boolean isSuggestionAll() {
        return suggestionAll;
    }

    public void setSuggestionAll(boolean suggestionAll) {
        this.suggestionAll = suggestionAll;
    }

    public String[] getIgnoreFilters() {
        return ignoreFilters;
    }

    public void setIgnoreFilters(String[] ignoreFilters) {
        this.ignoreFilters = ignoreFilters;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isDetails() {
        return details;
    }

    public void setDetails(boolean details) {
        this.details = details;
    }

    public String getPreferRegion() {
        return preferRegion;
    }

    public void setPreferRegion(String preferRegion) {
        this.preferRegion = preferRegion;
    }

    public String getPreferZone() {
        return preferZone;
    }

    public void setPreferZone(String preferZone) {
        this.preferZone = preferZone;
    }

    public String getPreferWire() {
        return preferWire;
    }

    public void setPreferWire(String preferWire) {
        this.preferWire = preferWire;
    }

    public String getPreferHost() {
        return preferHost;
    }

    public void setPreferHost(String preferHost) {
        this.preferHost = preferHost;
    }

    public String getPreferBackupHost() {
        return preferBackupHost;
    }

    public void setPreferBackupHost(String preferBackupHost) {
        this.preferBackupHost = preferBackupHost;
    }

    public String getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(String hypervisor) {
        this.hypervisor = hypervisor;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isBackup() {
        return backup;
    }

    public void setBackup(boolean backup) {
        this.backup = backup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DiskConfig[] getDisks() {
        return disks;
    }

    public void setDisks(DiskConfig[] disks) {
        this.disks = disks;
    }

    public SchedtagConfig[] getSchedtags() {
        return schedtags;
    }

    public void setSchedtags(SchedtagConfig[] schedtags) {
        this.schedtags = schedtags;
    }

    public IsolatedDeviceConfig[] getIsolatedDevices() {
        return isolatedDevices;
    }

    public void setIsolatedDevices(IsolatedDeviceConfig[] isolatedDevices) {
        this.isolatedDevices = isolatedDevices;
    }

    public BaremetalDiskConfig[] getBaremetalDiskConfigs() {
        return baremetalDiskConfigs;
    }

    public void setBaremetalDiskConfigs(BaremetalDiskConfig[] baremetalDiskConfigs) {
        this.baremetalDiskConfigs = baremetalDiskConfigs;
    }

    public String[] getInstanceGroupIds() {
        return instanceGroupIds;
    }

    public void setInstanceGroupIds(String[] instanceGroupIds) {
        this.instanceGroupIds = instanceGroupIds;
    }

    public boolean isSuggestion() {
        return suggestion;
    }

    public void setSuggestion(boolean suggestion) {
        this.suggestion = suggestion;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public boolean isLiveMigrate() {
        return liveMigrate;
    }

    public void setLiveMigrate(boolean liveMigrate) {
        this.liveMigrate = liveMigrate;
    }

    public String getCpuDesc() {
        return cpuDesc;
    }

    public void setCpuDesc(String cpuDesc) {
        this.cpuDesc = cpuDesc;
    }

    public String getCpuMicrocode() {
        return cpuMicrocode;
    }

    public void setCpuMicrocode(String cpuMicrocode) {
        this.cpuMicrocode = cpuMicrocode;
    }

    public JSONObject[] getPendingUsages() {
        return pendingUsages;
    }

    public void setPendingUsages(JSONObject[] pendingUsages) {
        this.pendingUsages = pendingUsages;
    }
}
