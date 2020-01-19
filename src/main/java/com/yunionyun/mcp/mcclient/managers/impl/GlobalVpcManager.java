package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class GlobalVpcManager extends ComputeManager {
    public GlobalVpcManager() {
        this(EndpointType.InternalURL);
    }

    public GlobalVpcManager(EndpointType endpointType){
        super("globalvpc", "globalvpcs",endpointType,
                new String[]{},
                new String[]{"ID", "Name", "Description", "Status", "Enabled"});
    }
}
