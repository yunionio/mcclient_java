package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.GlanceManager;

public class ImageUsageManager extends GlanceManager
{
    public ImageUsageManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns)
    {
        super("usage", "usages", new String[] { "Field", "Value" }, new String[] {});
    }
}
