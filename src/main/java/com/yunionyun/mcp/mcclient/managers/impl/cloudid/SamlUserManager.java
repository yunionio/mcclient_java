package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class SamlUserManager extends BaseCloudIdManager {
    public SamlUserManager() {
        this(EndpointType.InternalURL);
    }

    public SamlUserManager(EndpointType endpointType) {
        super("samluser", "samlusers", endpointType, null, null);
    }
}
