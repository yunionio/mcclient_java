package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class MonitorJointManager extends JointResourceManager {

	/**
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 * @param master
	 * @param slave
	 */
	public MonitorJointManager(
			String keyword,
			String keywordPlural,
			EndpointType endpointType,
			String[] columns,
			String[] adminColumns,
			BaseMonitorManager master,
			BaseMonitorManager slave) {
		super(
				"servicetree",
				null,
				endpointType,
				"v1",
				columns,
				adminColumns,
				keyword,
				keywordPlural,
				null,
				master,
				slave);
	}
}
