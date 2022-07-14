package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

public class CloudIdJointManager extends JointResourceManager {
	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 * @param master
	 * @param slave
	 */
	public CloudIdJointManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns,
			BaseCloudIdManager master,
			BaseCloudIdManager slave) {
		super(
				"cloudid",
				null,
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
