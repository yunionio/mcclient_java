package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseWebsocketManager extends ResourceManager
{

    public BaseWebsocketManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns)
    {
        super("websocket", EndpointType.InternalURL, "v1", columns, adminColumns, keyword, keywordPlural, null);
    }
    
}
