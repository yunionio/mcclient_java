package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ConfigsManager extends BaseNotifyManager {
    public ConfigsManager(){
       this(EndpointType.InternalURL);
    }

    public ConfigsManager(EndpointType endpointType){
        super("config", "configs", endpointType,
                new String[]{},
                new String[]{});
    }
}
