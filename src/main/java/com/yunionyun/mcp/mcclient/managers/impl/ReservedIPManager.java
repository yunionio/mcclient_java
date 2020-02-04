package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ReservedIPManager extends ComputeManager {
    public ReservedIPManager() {
        this(EndpointType.InternalURL);
    }

    public ReservedIPManager(EndpointType endpointType){
        super("reservedip", "reservedips", endpointType,
                new String[]{},
                new String[]{"Id", "Network_ID", "Network", "IP_addr", "Notes", "Expired_At", "Expired", "Status"});
    }
}
