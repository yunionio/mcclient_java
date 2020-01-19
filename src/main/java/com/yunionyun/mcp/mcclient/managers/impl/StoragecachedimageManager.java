package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class StoragecachedimageManager extends ComputeJointManager {
    public StoragecachedimageManager(StoragecacheManager master, CachedimageManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public StoragecachedimageManager(EndpointType endpointType,StoragecacheManager master, CachedimageManager slave){
        super("storagecachedimage", "storagecachedimages", endpointType,
                new String[]{"Storagecache_ID", "Storagecache",
                        "Cachedimage_ID", "Image", "Size", "Status", "Path", "Reference", "Storages"},
                new String[]{},master,slave);
    }
}
