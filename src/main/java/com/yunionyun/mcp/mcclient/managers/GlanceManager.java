package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class GlanceManager extends ResourceManager {
	public GlanceManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("image", EndpointType.InternalURL, "v1", columns, adminColumns, keyword, keywordPlural, null);
	}
}
