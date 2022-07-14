package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudIdJointManager;

public class CloudUserPolicyManager extends CloudIdJointManager {
    public CloudUserPolicyManager() {
        this(EndpointType.InternalURL);
    }

    public CloudUserPolicyManager(EndpointType endpointType) {
        super("clouduser_policy", "clouduser_policies", endpointType, null, null, new CloudUserManager(endpointType), new CloudPolicyManager(endpointType));
    }
}
