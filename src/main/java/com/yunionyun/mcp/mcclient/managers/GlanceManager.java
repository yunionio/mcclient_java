package com.yunionyun.mcp.mcclient.managers;

public class GlanceManager extends ResourceManager {
	public GlanceManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("image", "internal", "v1", columns, adminColumns, keyword, keywordPlural, null);
	}
}
