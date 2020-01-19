package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ElasticipManager extends ComputeManager {
    public ElasticipManager() {
        this(EndpointType.InternalURL);
    }

    public ElasticipManager(EndpointType endpointType) {
        super("eip", "eips", endpointType,
                new String[]{"ID", "Name", "IP_Addr", "Status", "Associate_Type", "Associate_ID", "Associate_Name"},
                new String[]{});
    }

}
