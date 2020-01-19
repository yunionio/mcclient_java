package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BaremetalagentManager extends ComputeManager {
    public BaremetalagentManager() {
       this(EndpointType.InternalURL);
    }

    public BaremetalagentManager(EndpointType endpointType) {
        super("baremetalagent", "baremetalagents",endpointType,
                new String[]{"ID", "Name", "Access_ip", "Manager_URI", "Status", "agent_type", "version", "zone", "zone_id"},
                new String[]{});
    }

}
