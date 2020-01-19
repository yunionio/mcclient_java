package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.keystone.Endpoint;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

public class RecipientManager extends BaseMonitorManager {

    public RecipientManager() {
        this(EndpointType.InternalURL);
    }

    public RecipientManager(EndpointType endpointType) {
        super("recipient", "recipients", endpointType,
                new String[]{"id", "type", "recipient_id", "recipient_name", "recipient_type", "node_labels"},
                new String[]{});
    }

}
