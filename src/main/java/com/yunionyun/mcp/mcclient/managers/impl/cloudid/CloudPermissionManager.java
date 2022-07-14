package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudPermissionManager extends BaseCloudIdManager {
    public CloudPermissionManager() {
        this(EndpointType.InternalURL);
    }

    public CloudPermissionManager(EndpointType endpointType) {
        super("cloudpermission", "cloudpermissions", endpointType, null, null);
    }
}
