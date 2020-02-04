package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ElasticCacheManager extends ComputeManager {
    public ElasticCacheManager() {
        this(EndpointType.InternalURL);
    }

    public ElasticCacheManager(EndpointType endpointType){
        super("elasticcache", "elasticcaches",endpointType,
                new String[]{"ID", "Name", "Cloudregion_Id", "Status", "InstanceType", "CapacityMB", "Engine", "EngineVersion"},
                new String[]{});
    }

    public JSONObject getLoginInfo(Session session, String id , JSONObject params) throws JSONClientException, McClientJavaBizException, IOException {
        return GetSpecific(session, id, "login-info", params);
    }
}
