package com.yunionyun.mcp.mcclient.managers.impl.keystone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class TenantManager extends KeystoneManager {
	public TenantManager() {
		this(EndpointType.AdminURL);
	}

	public TenantManager(EndpointType endpointType) {
		super(
				"tenant",
				"tenants",
				endpointType,
				new String[]{},
				new String[]{"ID", "Name", "Enabled", "Description"});
	}
}
