package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class VersionManager extends YunionAgentManager {
    public VersionManager() {
        this(EndpointType.InternalURL);
    }

    public VersionManager(EndpointType endpointType){
        super("version", "versions", endpointType,
                new String[]{},
                new String[]{});
    }
}
