package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author qj
 * @date 2022/07/14
 */
public class BaseCloudIdManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural EndpointType.InternalURL
	 * @param endpointType
	 * @param columns
	 * @param adminColumns
	 */
	public BaseCloudIdManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("cloudid", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
