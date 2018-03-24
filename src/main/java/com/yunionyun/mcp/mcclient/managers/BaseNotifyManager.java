package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseNotifyManager extends ResourceManager {

	public BaseNotifyManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("notify", EndpointType.InternalURL, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
