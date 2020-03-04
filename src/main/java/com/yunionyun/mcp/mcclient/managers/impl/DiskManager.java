package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class DiskManager extends ComputeManager {
	public DiskManager() {
		this(EndpointType.InternalURL);
	}

	public DiskManager(EndpointType endpointType) {
		super(
				"disk",
				"disks",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Billing_type",
						"Disk_size",
						"Status",
						"Disk_format",
						"Is_public",
						"Guest_count",
						"Storage_type",
						"Zone",
						"Device",
						"Guest",
						"Guest_id",
						"Created_at"
				},
				new String[]{"Storage", "Tenant"});
	}
}
