package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

public class RecipientManager extends BaseMonitorManager
{

    public RecipientManager()
    {
        super("recipient", "recipients",
                new String[] {"id", "type", "recipient_id", "recipient_name", "recipient_type", "node_labels"},
                new String[] {});
    }
    
}
