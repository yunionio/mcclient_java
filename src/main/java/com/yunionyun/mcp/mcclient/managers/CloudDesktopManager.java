package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class CloudDesktopManager extends ResourceManager {

	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public CloudDesktopManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("clouddesktop", endpointType, "v1", columns, adminColumns, keyword, keywordPlural, (String) null);
	}
}
