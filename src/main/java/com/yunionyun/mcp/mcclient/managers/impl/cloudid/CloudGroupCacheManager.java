package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class CloudGroupCacheManager extends BaseCloudIdManager {
    public CloudGroupCacheManager() {
        this(EndpointType.InternalURL);
    }

    public CloudGroupCacheManager(EndpointType endpointType) {
        super("cloudgroupcache", "cloudgroupcaches", endpointType, null, null);
    }
}
