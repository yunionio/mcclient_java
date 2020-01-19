package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ElasticCacheAclManager extends ComputeManager {
    public ElasticCacheAclManager() {
        this(EndpointType.InternalURL);
    }

    public ElasticCacheAclManager(EndpointType endpointType){
        super("elasticcacheacl", "elasticcacheacls",endpointType,
                new String[]{}, new String[]{});
    }
}
