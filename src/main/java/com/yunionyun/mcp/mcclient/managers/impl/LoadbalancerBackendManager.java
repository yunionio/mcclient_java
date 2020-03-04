package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerBackendManager extends ComputeManager {
	public LoadbalancerBackendManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerBackendManager(EndpointType endpointType) {
		super(
				"loadbalancerbackend",
				"loadbalancerbackends",
				endpointType,
				new String[]{
						"id",
						"name",
						"backend_group_id",
						"backend_id",
						"backend_type",
						"address",
						"port",
						"weight"
				},
				new String[]{"tenant"});
	}
}
