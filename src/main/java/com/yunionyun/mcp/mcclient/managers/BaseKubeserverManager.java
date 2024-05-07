package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class BaseKubeserverManager extends ResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural EndpointType.InternalURL
	 * @param endpointType
	 * @param columns
	 * @param adminColumns
	 */
	public BaseKubeserverManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("k8s", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
