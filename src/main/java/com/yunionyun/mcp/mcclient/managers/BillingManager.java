package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BillingManager extends ResourceManager {
	public BillingManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("billing", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
