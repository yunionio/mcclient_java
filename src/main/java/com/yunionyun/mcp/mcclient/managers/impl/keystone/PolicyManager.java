package com.yunionyun.mcp.mcclient.managers.impl.keystone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class PolicyManager extends KeystoneManager {
	public PolicyManager() {
		this(EndpointType.AdminURL);
	}

	public PolicyManager(EndpointType endpointType) {
		super(
				"policy",
				"policies",
				endpointType,
				new String[]{
						"id",
						"type",
						"policy",
						"enabled",
						"domain_id",
						"domain",
						"project_domain",
						"is_public",
						"description"
				},
				new String[]{});
	}
}
