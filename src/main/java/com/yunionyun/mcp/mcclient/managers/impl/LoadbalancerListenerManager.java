package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerListenerManager extends ComputeManager {
	public LoadbalancerListenerManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerListenerManager(EndpointType endpointType) {
		super(
				"loadbalancerlistener",
				"loadbalancerlisteners",
				endpointType,
				new String[]{
						"id",
						"name",
						"loadbalancer_id",
						"status",
						"listener_type",
						"listener_port",
						"backend_port",
						"egress_mbps",
						"acl_status",
						"acl_type"
				},
				new String[]{"tenant"});
	}
}
