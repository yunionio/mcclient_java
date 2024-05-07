package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class EndpointManager extends BaseKubeserverManager {
	public EndpointManager() {
		this(EndpointType.InternalURL);
	}

	public EndpointManager(EndpointType endpointType) {
		super(
				"k8s_endpoint",
				"k8s_endpoints",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
