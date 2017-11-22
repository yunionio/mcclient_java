package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class DomainManager extends KeystoneManager {
	public DomainManager() {
		super("domain", "domains",
		        new String[] {},
		        new String[] {"ID", "Name", "Enabled", "Description", "Driver"});
	}
}
