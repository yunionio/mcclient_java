package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class StoragecacheManager extends ComputeManager {
    public StoragecacheManager() {
        this(EndpointType.InternalURL);
    }

    public StoragecacheManager(EndpointType endpointType){
        super("storagecache", "storagecaches", endpointType,
                new String[]{"ID", "Name", "Path", "Storages", "size", "count"},
                new String[]{});
    }
}
