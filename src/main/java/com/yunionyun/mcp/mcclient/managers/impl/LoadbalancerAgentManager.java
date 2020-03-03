package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerAgentManager extends ComputeManager {
	public LoadbalancerAgentManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerAgentManager(EndpointType endpointType) {
		super(
				"loadbalanceragent",
				"loadbalanceragents",
				endpointType,
				new String[]{
						"id",
						"name",
						"hb_last_seen",
						"hb_timeout",
						"loadbalancers",
						"loadbalancer_listeners",
						"loadbalancer_listener_rules",
						"loadbalancer_backends",
						"loadbalancer_acls",
						"loadbalancer_certificates"
				},
				new String[]{});
	}
}
