package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudIdJointManager;

public class CloudGroupUserManager extends CloudIdJointManager {
    public CloudGroupUserManager() {
        this(EndpointType.InternalURL);
    }

    public CloudGroupUserManager(EndpointType endpointType) {
        super("cloudgroup_user", "cloudgroup_users", endpointType, null, null, new CloudGroupManager(endpointType), new CloudPolicyManager(endpointType));
    }
}
