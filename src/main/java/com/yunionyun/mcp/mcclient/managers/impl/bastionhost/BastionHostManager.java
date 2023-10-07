package com.yunionyun.mcp.mcclient.managers.impl.bastionhost;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BastionhostManager;

public class BastionHostManager extends BastionhostManager {
    public BastionHostManager() {
        this(EndpointType.InternalURL);
    }

    public BastionHostManager(EndpointType endpointType) {
        super("bation_host", "bastion_hosts",
                endpointType,
                new String[]{},
                new String[]{});
    }
}
