package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

public class ServerNetworkManager extends ComputeJointManager
{
    public ServerNetworkManager()
    {
        super("guestnetwork", "guestnetworks", 
                new String[] { "bw_limit", "created_at", "driver", "guest_id", "ifname", "index", "ip_addr", "mac_addr", "network_id", "update_version", "updated_at", "virtual" }, 
                new String[] {},
                new ServerManager(),
                new NetworkManager()
            );
    }
}
