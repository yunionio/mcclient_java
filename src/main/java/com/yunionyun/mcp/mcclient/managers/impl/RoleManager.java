package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class RoleManager extends KeystoneManager {
	public RoleManager() {
		super("role", "roles",
                            new String[] {},
                            new String[] {"ID", "Name", "Domain_Id"});
	}
}
