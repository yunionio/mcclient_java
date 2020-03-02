package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class InstanceSnapshotManager extends ComputeManager {
	public InstanceSnapshotManager() {
		this(EndpointType.InternalURL);
	}

	public InstanceSnapshotManager(EndpointType endpointType) {
		super(
				"instance_snapshot",
				"instance_snapshots",
				endpointType,
				new String[]{"ID", "Name", "Status", "Guest_Id"},
				new String[]{"Guest_Name", "Snapshots"});
	}
}
