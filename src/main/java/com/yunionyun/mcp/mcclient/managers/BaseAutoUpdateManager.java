package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class BaseAutoUpdateManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural EndpointType.InternalURL
	 * @param endpointType
	 * @param columns
	 * @param adminColumns
	 */
	public BaseAutoUpdateManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("autoupdate", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
