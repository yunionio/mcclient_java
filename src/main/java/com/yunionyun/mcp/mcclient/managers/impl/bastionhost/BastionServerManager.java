package com.yunionyun.mcp.mcclient.managers.impl.bastionhost;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BastionhostManager;

public class BastionServerManager extends BastionhostManager {
    public BastionServerManager() {
        this(EndpointType.InternalURL);
    }

    public BastionServerManager(EndpointType endpointType) {
        super("bastion_server", "bastion_servers",
                endpointType,
                new String[]{},
                new String[]{});
    }
}
