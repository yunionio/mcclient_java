package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseMonitorManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public BaseMonitorManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("servicetree", endpointType, "v1", columns, adminColumns, keyword, keywordPlural, null);
	}
}
