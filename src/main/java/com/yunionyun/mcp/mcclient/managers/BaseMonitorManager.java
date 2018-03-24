package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseMonitorManager extends ResourceManager {
	public BaseMonitorManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("servicetree", EndpointType.InternalURL, "v1", columns, adminColumns, keyword, keywordPlural, null);
	}
}
