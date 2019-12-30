package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ResourceManager;

/**
 * @author zxc
 * @date 2019/09/26
 */
public class GlanceManager extends ResourceManager {
    public GlanceManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
        super("image", EndpointType.InternalURL, "v1", columns, adminColumns, keyword, keywordPlural, (String)null);
    }
    public GlanceManager(String serviceType, String keyword, String keywordPlural, EndpointType endpointType){
        super(serviceType, endpointType, null, new String[0], new String[0], keyword, keywordPlural, (String)null);
    }

    public GlanceManager(EndpointType endpointType){
        super("image", endpointType, "v1", new String[0], new String[0], "quota", "quotas", (String)null);
    }
}
