package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerBackendGroupManager extends ComputeManager {
	public LoadbalancerBackendGroupManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerBackendGroupManager(EndpointType endpointType) {
		super(
				"loadbalancerbackendgroup",
				"loadbalancerbackendgroups",
				endpointType,
				new String[]{"id", "name", "loadbalancer_id"},
				new String[]{"tenant"});
	}
}
