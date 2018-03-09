package com.yunionyun.mcp.mcclient.managers;

public class BaseNotifyManager extends ResourceManager {

	public BaseNotifyManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("notify", "internal", null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
