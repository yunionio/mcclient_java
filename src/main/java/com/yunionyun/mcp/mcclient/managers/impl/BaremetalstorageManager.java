package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;
import javafx.scene.paint.Stop;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BaremetalstorageManager extends ComputeJointManager {
    public BaremetalstorageManager(HostManager master, StorageManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public BaremetalstorageManager(EndpointType endpointType,HostManager master, StorageManager slave){
        super("baremetalstorage", "baremetalstorages",endpointType,
                new String[]{"Baremetal_ID", "Baremetal", "Storage_ID", "Storage", "Config", "Real_capacity"},
                new String[]{},master,slave);
    }
}
