package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SnapshotPoliciyManager extends ComputeManager {
	public SnapshotPoliciyManager() {
		this(EndpointType.InternalURL);
	}

	public SnapshotPoliciyManager(EndpointType endpointType) {
		super(
				"snapshotpolicy",
				"snapshotpolicies",
				endpointType,
				new String[]{"ID", "Name", "Status", "Retention_Days", "Repeat_Weekdays", "Time_Points"},
				new String[]{});
	}
}
