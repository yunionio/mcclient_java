package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class HostManager extends ComputeManager
{
    public HostManager()
    {
        super("host", "hosts", 
                new String[] { "ID", "Name", "Access_mac", "Access_ip", "Manager_URI", "Status", "enabled", "host_status", "mem_size", "cpu_count", "storage_type", "host_type", "version" }, 
                new String[] { "sn" });
    }
}
