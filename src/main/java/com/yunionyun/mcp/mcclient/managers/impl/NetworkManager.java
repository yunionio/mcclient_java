package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class NetworkManager extends ComputeManager {
	public NetworkManager() {
		this(EndpointType.InternalURL);
	}

	public NetworkManager(EndpointType endpointType) {
		super(
				"network",
				"networks",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Guest_ip_start",
						"Guest_ip_end",
						"Guest_ip_mask",
						"wire_id",
						"wire",
						"is_public",
						"exit",
						"Ports",
						"vnics",
						"group_vnics",
						"bm_vnics",
						"reserve_vnics",
						"server_type"
				},
				new String[]{});
	}
}
