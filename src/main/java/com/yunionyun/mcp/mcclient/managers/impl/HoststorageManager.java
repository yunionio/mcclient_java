package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class HoststorageManager extends ComputeJointManager {
    public HoststorageManager(HostManager master, StorageManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public HoststorageManager(EndpointType endpointType, HostManager master, StorageManager slave) {
        super("hoststorage", "hoststorages", endpointType,
        new String[]{"Host_ID", "Host", "Storage_ID", "Storage", "Mount_point", "Capacity",
                "Used_capacity", "Waste_capacity", "Free_capacity", "cmtbound"},
                new String[]{}, master, slave);
    }
}
