package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class BaseCloudeventManager extends ResourceManager {
    /**
     *
     * @param keyword
     * @param keywordPlural EndpointType.InternalURL
     * @param endpointType
     * @param columns
     * @param adminColumns
     */
    public BaseCloudeventManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns){
        super("cloudevent",endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
