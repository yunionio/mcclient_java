package com.yunionyun.mcp.mcclient.managers;

public class ComputeManager extends ResourceManager {

	public ComputeManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns) {
		super("compute", "internal", null, columns, adminColumns, keyword, keywordPlural, null);
	}
}
