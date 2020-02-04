package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class MeterManager extends ResourceManager {

    /**
     *
     * @param keyword
     * @param keywordPlural
     * @param endpointType Internal
     * @param columns
     * @param adminColumns
     */
    public MeterManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
        super("meter", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
    }
}
