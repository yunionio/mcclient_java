package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class HostManager extends ComputeManager {
    public HostManager() {
        this(EndpointType.InternalURL);
    }

    public HostManager(EndpointType endpointType) {
        super("host", "hosts",endpointType,
                new String[]{"ID", "Name", "Access_mac", "Access_ip", "Manager_URI", "Status", "enabled", "host_status", "Guests", "Running_guests", "storage", "storage_used", "storage_virtual", "disk_used", "mem_size", "mem_used", "mem_free", "mem_commit", "cpu_count", "cpu_used", "cpu_commit", "cpu_commit_rate", "mem_commit_rate", "cpu_commit_bound", "mem_commit_bound", "sn", "storage_type", "host_type", "version", "schedtags", "storage_size"},
                new String[]{});
    }
}
