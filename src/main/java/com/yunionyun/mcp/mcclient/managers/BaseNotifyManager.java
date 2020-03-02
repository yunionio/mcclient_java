package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class BaseNotifyManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public BaseNotifyManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("notify", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
