package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class SnapshotManager extends ComputeManager {
	
	public SnapshotManager() {
		super("snapshot", "snapshots",
               new String[] {"ID", "Name", "Size", "Status", "Disk_id", "Storage_id"},
               new String[] {});
	}
	
 }
