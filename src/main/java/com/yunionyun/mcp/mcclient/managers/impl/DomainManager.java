package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

public class DomainManager extends KeystoneManager {
	public DomainManager() {
		this(EndpointType.AdminURL);
	}

	public DomainManager(EndpointType endpointType) {
		super("domain", "domains",endpointType,
				new String[] {"ID", "Name", "Enabled", "Description", "Driver"},
				new String[] {});
	}
}
