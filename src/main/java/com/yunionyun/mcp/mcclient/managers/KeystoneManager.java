package com.yunionyun.mcp.mcclient.managers;

public class KeystoneManager extends ResourceManager {
	
	public KeystoneManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("identity", "admin", "v3", columns, adminColumns, keyword, keywordPlural, null);
	}

}
