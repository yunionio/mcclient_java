package com.yunionyun.mcp.mcclient.managers;

public class ComputeJointManager extends JointResourceManager {
	public ComputeJointManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns, ComputeManager master, ComputeManager slave) {
		super("compute", "internal", null, columns, adminColumns, keyword, keywordPlural, null, master, slave);
	}
}
