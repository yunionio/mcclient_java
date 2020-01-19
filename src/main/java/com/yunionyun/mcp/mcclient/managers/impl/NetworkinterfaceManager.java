package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NetworkinterfaceManager extends ComputeManager {
    public NetworkinterfaceManager() {
        this(EndpointType.InternalURL);
    }

    public NetworkinterfaceManager(EndpointType endpointType) {
        super("networkinterface", "networkinterfaces", endpointType,
                new String[]{"ID", "Name", "Status", "Mac", "Region", "Associate_Type", "Associate_Id"},
                new String[]{});
    }
}
