package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudPolicyManager extends BaseCloudIdManager {
    public CloudPolicyManager() {
        this(EndpointType.InternalURL);
    }

    public CloudPolicyManager(EndpointType endpointType) {
        super("cloudpolicy", "cloudpolicies", endpointType, null, null);
    }
}
