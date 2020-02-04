package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceManager extends ComputeManager {
    public DBInstanceManager() {
        this(EndpointType.InternalURL);
    }

    public DBInstanceManager(EndpointType endpointType){
        super("dbinstance", "dbinstances",endpointType,
                new String[]{"ID", "Name", "Billing_type", "Cloudregion_Id", "Status", "Vcpu_Count", "Vmem_Size_Mb"},
                new String[]{});
    }
}
