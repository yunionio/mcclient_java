package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/03/17
 */
public class GnocchiManager extends ResourceManager {
	public GnocchiManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
		super("metric", null, EndpointType.AdminURL, "v3", columns, adminColumns, keyword, keywordPlural, (String) null);
	}
}
