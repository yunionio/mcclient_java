package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceNetworkManager extends ComputeJointManager {
    public DBInstanceNetworkManager(DBInstanceManager master, NetworkManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public DBInstanceNetworkManager(EndpointType endpointType,DBInstanceManager master, NetworkManager slave) {
        super("dbinstancenetwork", "dbinstancenetworks",endpointType,
                new String[]{"Instance_Id", "Network_Id", "IP_Addr"},
                new String[]{}, master, slave);
    }
}
