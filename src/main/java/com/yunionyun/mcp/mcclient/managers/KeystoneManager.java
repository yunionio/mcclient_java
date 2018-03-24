package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class KeystoneManager extends ResourceManager {
	
	public KeystoneManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("identity", EndpointType.AdminURL, "v3", columns, adminColumns, keyword, keywordPlural, null);
	}

}
