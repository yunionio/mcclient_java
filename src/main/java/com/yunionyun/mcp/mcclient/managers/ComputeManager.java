package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ComputeManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public ComputeManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("compute", "v2", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
