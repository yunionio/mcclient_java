package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudGroupManager extends BaseCloudIdManager {
    public CloudGroupManager() {
        this(EndpointType.InternalURL);
    }

    public CloudGroupManager(EndpointType endpointType) {
        super("cloudgroup", "cloudgroups", endpointType, null, null);
    }
}
