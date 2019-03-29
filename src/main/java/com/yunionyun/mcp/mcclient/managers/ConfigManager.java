package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ConfigManager extends ResourceManager
{
    
    public ConfigManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns)
    {
        super("yunionconf", EndpointType.InternalURL, null, columns, adminColumns, keyword, keywordPlural, null);
    }
    
}
