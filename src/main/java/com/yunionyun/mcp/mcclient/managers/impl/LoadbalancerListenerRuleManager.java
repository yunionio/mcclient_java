package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerListenerRuleManager extends ComputeManager {
    public LoadbalancerListenerRuleManager() {
        this(EndpointType.InternalURL);
    }

    public LoadbalancerListenerRuleManager(EndpointType endpointType){
        super("loadbalancerlistenerrule", "loadbalancerlistenerrules", endpointType,
                new String[]{"id", "name", "listener_id", "status", "domain", "path", "backend_id"},
                new String[]{"tenant"});
    }
}
