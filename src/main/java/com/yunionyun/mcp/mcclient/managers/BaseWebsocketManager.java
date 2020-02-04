package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseWebsocketManager extends ResourceManager {
    /**
     *
     * @param keyword
     * @param keywordPlural
     * @param endpointType  EndpointType.InternalURL
     * @param columns
     * @param adminColumns
     */
    public BaseWebsocketManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
        super("websocket", endpointType, "v1", columns, adminColumns, keyword, keywordPlural, null);
    }

}
