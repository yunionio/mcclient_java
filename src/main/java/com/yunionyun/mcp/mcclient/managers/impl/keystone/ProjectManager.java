package com.yunionyun.mcp.mcclient.managers.impl.keystone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class ProjectManager extends KeystoneManager {
	public ProjectManager() {
		this(EndpointType.AdminURL);
	}

	public ProjectManager(EndpointType endpointType) {
		super(
				"project",
				"projects",
				endpointType,
				new String[]{},
				new String[]{"ID", "Name", "Domain_Id", "Enabled", "Description"});
	}
}
