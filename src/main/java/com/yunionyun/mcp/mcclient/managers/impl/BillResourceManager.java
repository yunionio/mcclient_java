package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BillResourceManager extends MeterManager {
    public BillResourceManager() {
        this(EndpointType.InternalURL);
    }

    public BillResourceManager(EndpointType endpointType){
        super("bill_resource", "bill_resources",endpointType,
                new String[]{"account", "platform", "region", "manager_project", "res_id", "res_type", "res_name", "charge_type", "res_fee"},
                new String[]{});
    }
}
