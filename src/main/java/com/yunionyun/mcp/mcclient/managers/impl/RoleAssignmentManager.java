package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class RoleAssignmentManager extends KeystoneManager {
	public RoleAssignmentManager() {
		super("role_assignment", "role_assignments",
                new String[] {"Scope", "User", "Group", "Role"},
                new String[] {});
	}
	public RoleAssignmentManager(EndpointType endpointType) {
		super("role_assignment", "role_assignments", endpointType,
				new String[] {"Scope", "User", "Group", "Role"},
				new String[] {});
	}
}
