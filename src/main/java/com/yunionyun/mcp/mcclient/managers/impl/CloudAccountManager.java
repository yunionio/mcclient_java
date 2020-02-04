package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class CloudAccountManager extends ComputeManager
{
    public CloudAccountManager() {
        this(EndpointType.InternalURL);
    }

    public CloudAccountManager(EndpointType endpointType){
        super("cloudaccount", "cloudaccounts", endpointType,new String[] { "id", "access_url", "account", "enabled", "is_emulated","last_sync", "name", "provider", "status" }, new String[] {});
    }
}
