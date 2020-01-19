package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class RegisterManager extends YunionAgentManager {
    public RegisterManager() {
        this(EndpointType.InternalURL);
    }

    public RegisterManager(EndpointType endpointType){
        super("register", "registers", endpointType,
                new String[]{},
                new String[]{});
    }

}
