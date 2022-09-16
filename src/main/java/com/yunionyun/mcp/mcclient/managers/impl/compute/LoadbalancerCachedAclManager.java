package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerCachedAclManager extends ComputeManager {
	public LoadbalancerCachedAclManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerCachedAclManager(EndpointType endpointType) {
		super(
				"cachedloadbalanceracl",
				"cachedloadbalanceracls",
				endpointType,
				new String[]{"id", "acl_id", "name", "acl_entries"},
				new String[]{"tenant"});
	}
}
