package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class RoleAssignmentManager extends KeystoneManager {
	public RoleAssignmentManager() {
		this(EndpointType.AdminURL);
	}
	public RoleAssignmentManager(EndpointType endpointType) {
		super("role_assignment", "role_assignments", endpointType,
				new String[] {"Scope", "User", "Group", "Role"},
				new String[] {});
	}
}
