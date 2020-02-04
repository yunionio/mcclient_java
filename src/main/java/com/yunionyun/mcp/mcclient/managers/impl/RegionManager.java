package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class RegionManager extends KeystoneManager {
    public RegionManager() {
        this(EndpointType.AdminURL);

    }

    public RegionManager(EndpointType endpointType){
        super("region", "regions", endpointType,
                new String[]{},
                new String[]{"ID", "Name", "Description"});
    }
}
