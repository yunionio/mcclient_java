package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerAclManager extends ComputeManager {
	public LoadbalancerAclManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerAclManager(EndpointType endpointType) {
		super(
				"loadbalanceracl",
				"loadbalanceracls",
				endpointType,
				new String[]{"id", "name", "acl_entries"},
				new String[]{"tenant"});
	}
}
