package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ConfigManager extends ResourceManager {

	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType
	 * @param columns
	 * @param adminColumns
	 */
	public ConfigManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("yunionconf", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
