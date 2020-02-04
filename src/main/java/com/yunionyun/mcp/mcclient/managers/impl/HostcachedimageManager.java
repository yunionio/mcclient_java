package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class HostcachedimageManager extends ComputeJointManager {
    public HostcachedimageManager(HostManager master, CachedimageManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public HostcachedimageManager(EndpointType endpointType, HostManager master, CachedimageManager slave) {
        super("hostcachedimage", "hostcachedimages", endpointType,
                new String[]{"Host_ID", "Host", "Cachedimage_ID", "Image", "Size", "Status", "Path", "Reference"},
                new String[]{}, master, slave);
    }
}
