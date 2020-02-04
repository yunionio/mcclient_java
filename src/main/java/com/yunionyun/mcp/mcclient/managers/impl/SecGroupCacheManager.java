package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SecGroupCacheManager extends ComputeManager {
    public SecGroupCacheManager() {
        this(EndpointType.InternalURL);
    }

    public SecGroupCacheManager(EndpointType endpointType){
        super("secgroupcache", "secgroupcaches", endpointType,
                new String[]{"ID", "Name", "Descritpion", "Status",
                        "Vpc_Id", "Vpc", "Region", "Account", "Secgroup_Id"},
                new String[]{});
    }
}
