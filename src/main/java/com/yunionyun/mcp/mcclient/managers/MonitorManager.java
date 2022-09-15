package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class MonitorManager extends ResourceManager {

    /**
     * @param keyword
     * @param keywordPlural
     * @param endpointType  Internal
     * @param columns
     * @param adminColumns
     */
    public MonitorManager(
            String keyword,
            String keywordPlural,
            EndpointType endpointType,
            String[] columns,
            String[] adminColumns) {
        super("monitor", null, endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
