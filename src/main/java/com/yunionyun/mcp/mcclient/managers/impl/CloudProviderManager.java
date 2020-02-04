package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class CloudProviderManager extends ComputeManager {

    public CloudProviderManager() {
        this(EndpointType.InternalURL);
    }

    public CloudProviderManager(EndpointType endpointType) {
        super("cloudprovider", "cloudproviders", endpointType, new String[]{"id", "access_url", "account", "enabled", "is_emulated", "last_sync", "name", "provider", "status", "cloudaccount_id", "tenant_id"}, new String[]{});
    }
}
