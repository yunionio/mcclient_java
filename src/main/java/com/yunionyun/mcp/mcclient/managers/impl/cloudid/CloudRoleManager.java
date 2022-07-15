package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudRoleManager extends BaseCloudIdManager {
    public CloudRoleManager() {
        this(EndpointType.InternalURL);
    }

    public CloudRoleManager(EndpointType endpointType) {
        super("cloudrole", "cloudroles", endpointType, null, null);
    }
}
