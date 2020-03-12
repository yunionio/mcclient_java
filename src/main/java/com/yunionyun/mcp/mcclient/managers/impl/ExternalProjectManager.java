package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ExternalProjectManager extends ComputeManager {
	public ExternalProjectManager() {
		this(EndpointType.InternalURL);
	}

	public ExternalProjectManager(EndpointType endpointType) {
		super(
				"externalproject",
				"externalprojects",
				endpointType,
				new String[]{"ID", "Name", "External_Id", "Tenant_id", "Tenant", "Manager_id", "Manager"},
				new String[]{});
	}
}
