package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.keystone.Endpoint;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AccoutBalanceManager extends MeterManager {
    public AccoutBalanceManager() {
       this(EndpointType.InternalURL);
    }
    public AccoutBalanceManager(EndpointType endpointType){
        super("account_balance", "account_balances", endpointType,
                new String[]{"account_type", "available_amount", "current_outcome", "current_income"},
                new String[]{});
    }
}
