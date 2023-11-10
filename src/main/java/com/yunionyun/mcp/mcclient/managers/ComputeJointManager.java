package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class ComputeJointManager extends JointResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 * @param master
	 * @param slave
	 */
	public ComputeJointManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns,
			ComputeManager master,
			ComputeManager slave) {
		super(
				"compute",
				endpointType,
				null,
				columns,
				adminColumns,
				keyword,
				keywordPlural,
				null,
				master,
				slave);
	}
}
