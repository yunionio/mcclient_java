package com.yunionyun.mcp.mcclient.managers.impl.keystone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class IdentityProviderManager extends KeystoneManager {
	public IdentityProviderManager() {
		this(EndpointType.AdminURL);
	}

	public IdentityProviderManager(EndpointType endpointType) {
		super(
				"identity_provider",
				"identity_providers",
				endpointType,
				new String[]{},
				new String[]{
						"ID",
						"Name",
						"Driver",
						"Template",
						"Enabled",
						"Status",
						"Sync_Status",
						"Error_count",
						"Sync_Interval_Seconds"
				});
	}
}
