package com.yunionyun.mcp.mcclient.managers.impl.keystone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class RoleManager extends KeystoneManager {
	public RoleManager() {
		this(EndpointType.AdminURL);
	}

	public RoleManager(EndpointType endpointType) {
		super("role", "roles", endpointType, new String[]{}, new String[]{"ID", "Name", "Domain_Id"});
	}
}
