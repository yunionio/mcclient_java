package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseSnapShotManager extends ComputeManager {

	public BaseSnapShotManager(
			String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super(keyword, keywordPlural, EndpointType.InternalURL, columns, adminColumns);
		// TODO Auto-generated constructor stub
	}
}
