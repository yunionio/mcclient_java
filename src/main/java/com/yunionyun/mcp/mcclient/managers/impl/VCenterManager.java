package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class VCenterManager extends ComputeManager {
	public VCenterManager() {
		super("vcenter", "vcenters",
                            new String[]{"ID", "Name", "Hostname", "Status", "Version", "Host_count"},
                            new String[]{});
	}
}
