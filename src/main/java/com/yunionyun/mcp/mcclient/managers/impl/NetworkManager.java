package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class NetworkManager extends ComputeManager {
	public NetworkManager() {
		super("network", "networks",
               new String[] {"ID", "Name", "Guest_ip_start",
                       "Guest_ip_end", "Guest_ip_mask",
                       "wire_id", "wire", "is_public", "exit", "Ports",
                       "vnics",
                       "group_vnics", "bm_vnics", "reserve_vnics", "server_type"},
             new String[] {});
	}
	/*Networks = NewComputeManager("network", "networks",
             []string{"ID", "Name", "Guest_ip_start",
                    "Guest_ip_end", "Guest_ip_mask",
                    "wire_id", "wire", "is_public", "exit", "Ports",
                    "vnics",
                    "group_vnics", "bm_vnics", "reserve_vnics", "server_type"},
             []string{})*/
 }
