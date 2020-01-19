package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class InstanceGroupManager extends ComputeManager {
    public InstanceGroupManager() {
        this(EndpointType.InternalURL);
    }

    public InstanceGroupManager(EndpointType endpointType) {
        super("instancegroup", "instancegroups", endpointType,
                new String[]{"ID", "Name", "Service_Type", "Parent_Id", "Zone_Id", "Sched_Strategy", "Domain_Id", "Project_Id",
                        "Granularity", "Is_Froced_Sep"},
                new String[]{});
    }
}
