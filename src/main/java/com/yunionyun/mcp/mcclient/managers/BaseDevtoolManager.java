package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class BaseDevtoolManager extends ResourceManager {
    /**
     *
     * @param keyword
     * @param keywordPlural EndpointType.InternalURL
     * @param endpointType
     * @param columns
     * @param adminColumns
     */
    public BaseDevtoolManager(String keyword, String keywordPlural, EndpointType endpointType,String[] columns, String[] adminColumns){
        super("devtool", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
