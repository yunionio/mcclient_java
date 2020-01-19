package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseWebConsoleManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class WebConsoleManager extends BaseWebConsoleManager {
    public WebConsoleManager() {
        this(EndpointType.InternalURL);
    }

    public WebConsoleManager(EndpointType endpointType){
        super("webconsole","webconsole", endpointType, new String[]{},new String[]{});
    }
}
