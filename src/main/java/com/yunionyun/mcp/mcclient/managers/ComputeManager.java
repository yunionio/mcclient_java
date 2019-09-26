package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ComputeManager extends ResourceManager {

	public ComputeManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("compute", EndpointType.InternalURL, null, columns, adminColumns, keyword, keywordPlural, null);
	}

	public ComputeManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
		super("compute", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
