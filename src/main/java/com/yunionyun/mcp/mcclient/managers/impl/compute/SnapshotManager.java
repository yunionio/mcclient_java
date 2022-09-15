package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class SnapshotManager extends ComputeManager {

	public SnapshotManager() {
		this(EndpointType.InternalURL);
	}

	public SnapshotManager(EndpointType endpointType) {
		super(
				"snapshot",
				"snapshots",
				endpointType,
				new String[]{"ID", "Name", "Size", "Status", "Disk_id", "Storage_id"},
				new String[]{});
	}
}
