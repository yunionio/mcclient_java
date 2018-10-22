package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class CloudProviderManager extends ComputeManager
{
    public CloudProviderManager()
    {
    	super("cloudaccount", "cloudaccounts", new String[] { "id", "access_url", "account", "enabled", "is_emulated", "last_sync", "name", "provider", "status" }, new String[] {});
        //super("cloudprovider", "cloudproviders", new String[] { "id", "access_url", "account", "enabled", "is_emulated", "last_sync", "name", "provider", "status" }, new String[] {});
    }
}
