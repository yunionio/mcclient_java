package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class YunionAgentManager extends ResourceManager {

    /**
     *
     * @param keyword
     * @param keywordPlural
     * @param endpointType EndpointType.InternalURL
     * @param columns
     * @param adminColumns
     */
    public YunionAgentManager(String keyword, String keywordPlural,EndpointType endpointType, String[] columns, String[] adminColumns){
        super("yunionagent",endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
