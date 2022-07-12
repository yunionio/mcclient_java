package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class KeystoneManager extends ResourceManager {

	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.AdminURL
	 * @param columns
	 * @param adminColumns
	 */
	public KeystoneManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("identity", null, endpointType, "v3", columns, adminColumns, keyword, keywordPlural, null);
	}
}
