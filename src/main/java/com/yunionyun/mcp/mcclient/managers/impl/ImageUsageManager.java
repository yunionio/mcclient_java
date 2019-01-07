package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.GlanceManager;

public class ImageUsageManager extends GlanceManager
{
    public ImageUsageManager()
    {
        super("usage", "usages", new String[] { "Field", "Value" }, new String[] {});
    }
}
