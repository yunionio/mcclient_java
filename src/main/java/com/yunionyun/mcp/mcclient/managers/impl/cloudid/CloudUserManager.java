package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudUserManager extends BaseCloudIdManager {
    public CloudUserManager() {
        this(EndpointType.InternalURL);
    }

    public CloudUserManager(EndpointType endpointType) {
        super("clouduser", "cloudusers", endpointType, null, null);
    }
}
