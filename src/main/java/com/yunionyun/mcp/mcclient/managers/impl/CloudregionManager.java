package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class CloudregionManager extends ComputeManager {
    public CloudregionManager() {
        this(EndpointType.InternalURL);
    }

    public CloudregionManager(EndpointType endpointType) {
        super("cloudregion", "cloudregions", endpointType, new String[]{"ID", "Name", "Enabled", "Status", "Provider", "Latitude", "Longitude"}, new String[]{});
    }
}
