package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ElasticipManager extends ComputeManager
{
    public ElasticipManager()
    {
        super("eip", "eips", new String[] { "ID", "Name", "IP_Addr", "Status", "Associate_Type", "Associate_ID", "Associate_Name" }, new String[] {});
    }
}
