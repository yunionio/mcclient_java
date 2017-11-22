package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ServerManager extends ComputeManager {
	public ServerManager() {
		super("server", "servers",
               new String[] {"ID", "Name", "Billing_type",
            "IPs", "Disk", "Status",
            "vcpu_count", "vmem_size",
            "ext_bw", "Zone_name",
            "Secgroup", "Secgrp_id",
            "vrouter", "vrouter_id",
            "Created_at", "Group_name",
            "Group_id", "Hypervisor"},
             new String[] {"Host", "Tenant", "is_system"});
	}
	
 }
