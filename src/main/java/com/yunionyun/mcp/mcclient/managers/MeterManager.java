package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class MeterManager extends ResourceManager
{
    
    public MeterManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns)
    {
        super("meter", EndpointType.InternalURL, null, columns, adminColumns, keyword, keywordPlural, null);
    }
    
}
