package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class GlanceManager extends ResourceManager {

	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public GlanceManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super(
				"image", endpointType, "v1", columns, adminColumns, keyword, keywordPlural, (String) null);
	}

	public GlanceManager(
			String serviceType, String keyword, String keywordPlural, EndpointType endpointType) {
		super(
				serviceType,
				endpointType,
				(String) null,
				new String[0],
				new String[0],
				keyword,
				keywordPlural,
				(String) null);
	}
}
