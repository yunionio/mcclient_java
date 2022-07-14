package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudIdJointManager;

public class CloudGroupPolicyManager extends CloudIdJointManager {
    public CloudGroupPolicyManager() {
        this(EndpointType.InternalURL);
    }

    public CloudGroupPolicyManager(EndpointType endpointType) {
        super("cloudgroup_policy", "cloudgroup_policies", endpointType, null, null, new CloudGroupManager(endpointType), new CloudPolicyManager(endpointType));
    }
}
