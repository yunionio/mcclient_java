package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ConfigManager;
import org.omg.Dynamic.Parameter;

public class ParameterManager extends ConfigManager {
    public ParameterManager() {
        this(EndpointType.InternalURL);
    }

    public ParameterManager(EndpointType endpointType) {
        super("parameter", "parameters", endpointType,
                new String[]{"ID", "Name", "Value", "namespace", "namespace_id", "update_version", "can_delete", "can_update", "created_at", "created_by", "updated_at"},
                new String[]{});
    }

}
