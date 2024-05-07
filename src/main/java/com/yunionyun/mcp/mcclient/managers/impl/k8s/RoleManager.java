package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class RoleManager extends BaseKubeserverManager {
	public RoleManager() {
		this(EndpointType.InternalURL);
	}

	public RoleManager(EndpointType endpointType) {
		super(
				"rbacrole",
				"rbacroles",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
