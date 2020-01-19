package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SecGroupRuleManager extends ComputeManager {
    public SecGroupRuleManager() {
        this(EndpointType.InternalURL);
    }

    public SecGroupRuleManager(EndpointType endpointType){
        super("secgrouprule", "secgrouprules", endpointType,
                new String[]{"ID", "Name", "Direction", "Action", "Protocol", "Ports", "Priority", "Cidr", "Description"},
                new String[]{"SecGroups"});
    }
}
