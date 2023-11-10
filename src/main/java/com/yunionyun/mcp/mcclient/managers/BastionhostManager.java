package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BastionhostManager extends ResourceManager {
    public BastionhostManager(
            String keyword,
            String keywordPlural,
            EndpointType endpointType,
            String[] columns,
            String[] adminColumns) {
        super("bastionhost", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
