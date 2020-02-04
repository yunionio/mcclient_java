package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NatGatewayManager extends ComputeManager {
    public NatGatewayManager() {
        this(EndpointType.InternalURL);
    }

    public NatGatewayManager(EndpointType endpointType){
        super("natgateway", "natgateways", endpointType,
                new String[]{"ID", "Name", "Enabled", "Status", "Cloudregion_Id", "Region", "Vpc_Id", "Charge_Type", "Nat_Spec"},
                new String[]{});
    }
}
