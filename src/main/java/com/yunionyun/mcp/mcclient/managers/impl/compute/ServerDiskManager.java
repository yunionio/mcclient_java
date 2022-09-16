package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

public class ServerDiskManager extends ComputeJointManager {
	public ServerDiskManager() {
		this(EndpointType.InternalURL, new ServerManager(), new DiskManager());
	}

	public ServerDiskManager(ServerManager master, DiskManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public ServerDiskManager(EndpointType endpointType, ServerManager master, DiskManager slave) {
		super(
				"guestdisk",
				"guestdisks",
				endpointType,
				new String[]{
						"Guest_ID",
						"Guest",
						"Disk_ID",
						"Disk",
						"Disk_size",
						"Driver",
						"Cache_mode",
						"Index",
						"Status"
				},
				new String[]{},
				master,
				slave);
	}
}
