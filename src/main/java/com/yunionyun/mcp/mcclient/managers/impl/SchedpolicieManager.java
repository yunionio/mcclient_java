package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedpolicieManager extends ComputeManager {
    public SchedpolicieManager() {
        this(EndpointType.InternalURL);
    }

    public SchedpolicieManager(EndpointType endpointType){
        super("schedpolicy", "schedpolicies", endpointType,
                new String[]{"ID", "Name", "Description", "Condition", "Schedtag", "Resource_Type", "Schedtag_Id",
                        "Strategy", "Enabled"},
                new String[]{});
    }
}
