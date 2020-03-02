package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AnsibleManager extends ResourceManager {
	public AnsibleManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns) {
		super("ansible", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
