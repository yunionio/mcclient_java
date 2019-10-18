package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class SkuManager extends ComputeManager
{
    public SkuManager()
    {
        super("serversku", "serverskus", 
                new String[] { "attached_disk_count", "attached_disk_size_gb", "can_delete", "can_update", "cloudregion_id", "cpu_core_count", "created_at", "data_disk_max_count", "gpu_attachable", "gpu_count", "gpu_max_count", "id", "instance_type_category", "instance_type_family", "is_emulated", "local_category", "memory_size_mb", "name", "nic_max_count", "os_name", "postpaid_status", "prepaid_status", "sys_disk_max_size_gb", "sys_disk_min_size_gb", "sys_disk_resizable", "total_guest_count", "update_version", "updated_at" }, 
                new String[] { "Host", "Tenant", "is_system" });
    }
    public SkuManager(EndpointType endpointType)
    {
        super("serversku", "serverskus", endpointType,
                new String[] { "attached_disk_count", "attached_disk_size_gb", "can_delete", "can_update", "cloudregion_id", "cpu_core_count", "created_at", "data_disk_max_count", "gpu_attachable", "gpu_count", "gpu_max_count", "id", "instance_type_category", "instance_type_family", "is_emulated", "local_category", "memory_size_mb", "name", "nic_max_count", "os_name", "postpaid_status", "prepaid_status", "sys_disk_max_size_gb", "sys_disk_min_size_gb", "sys_disk_resizable", "total_guest_count", "update_version", "updated_at" },
                new String[] { "Host", "Tenant", "is_system" });
    }
}
