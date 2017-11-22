package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class UserManager extends KeystoneManager {
	public UserManager() {
		super("user", "users",
                new String[] {},
                new String[]{"ID", "Name", "Domain_Id",
                        "Enabled", "Email", "Mobile"});
	}
}
