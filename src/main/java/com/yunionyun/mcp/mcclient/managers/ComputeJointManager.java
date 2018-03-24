package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ComputeJointManager extends JointResourceManager {
	public ComputeJointManager(String keyword, String keywordPlural, String[] columns, String[] adminColumns, ComputeManager master, ComputeManager slave) {
		super("compute", EndpointType.InternalURL, null, columns, adminColumns, keyword, keywordPlural, null, master, slave);
	}
}
