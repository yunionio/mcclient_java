package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseLogActionManager extends ResourceManager {
    /**
     *
     * @param keyword
     * @param keywordPlural
     * @param endpointType EndpointType.InternalURL
     * @param columns
     * @param adminColumns
     */
    public BaseLogActionManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
        super("log", endpointType, "v1", columns, adminColumns, keyword, keywordPlural, null);
    }
}
