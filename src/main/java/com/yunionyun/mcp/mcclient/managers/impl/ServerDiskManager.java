package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

public class ServerDiskManager extends ComputeJointManager {
	public ServerDiskManager() {
		super("guestdisk",
                "guestdisks",
                new String[] {"Guest_ID", "Guest",
                    "Disk_ID", "Disk", "Disk_size",
                    "Driver", "Cache_mode", "Index", "Status"},
                new String[] {},
                new ServerManager(),
                new DiskManager()
				);
	}
}
