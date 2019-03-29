package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ConfigManager;

public class ParameterManager extends ConfigManager
{
    public ParameterManager()
    {
        super("parameter", "parameters", 
                new String[] { "ID", "Name", "Value", "namespace", "namespace_id", "update_version", "can_delete", "can_update", "created_at", "created_by", "updated_at" },
                new String[] {});
    }
    
}
