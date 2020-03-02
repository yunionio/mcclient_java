package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class VCenterManager extends ComputeManager {
	public VCenterManager() {
		this(EndpointType.InternalURL);
	}

	public VCenterManager(EndpointType endpointType) {
		super(
				"vcenter",
				"vcenters",
				endpointType,
				new String[]{"ID", "Name", "Hostname", "Status", "Version", "Host_count"},
				new String[]{});
	}
}
