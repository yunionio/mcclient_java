package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class RouteTableManager extends ComputeManager {
    public RouteTableManager() {
        this(EndpointType.InternalURL);
    }

    public RouteTableManager(EndpointType endpointType){
        super("route_table", "route_tables", endpointType,
                new String[]{"id", "name", "type", "vpc", "vpc_id", "routes"},
                new String[]{"tenant"});
    }
}
