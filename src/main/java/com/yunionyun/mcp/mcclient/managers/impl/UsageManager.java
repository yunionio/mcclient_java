package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class UsageManager extends ComputeManager
{
    public UsageManager()
    {
    	super("usage", "usages", new String[] { "Field", "Value" }, new String[] {});
    }
}
