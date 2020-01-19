package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancernetworkManager extends ComputeJointManager {
    public LoadbalancernetworkManager(LoadbalancerManager master, NetworkManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public LoadbalancernetworkManager(EndpointType endpointType,LoadbalancerManager master, NetworkManager slave){
        super("loadbalancernetwork", "loadbalancernetworks", endpointType,
                new String[]{"Loadbalancer_ID", "Loadbalancer", "Network_ID", "Network", "Ip_Addr"},
                new String[]{},master,slave);
    }
}
