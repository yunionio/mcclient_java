package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SecGroupManager extends ComputeManager {
	public SecGroupManager() {
		this(EndpointType.InternalURL);
	}

	public SecGroupManager(EndpointType endpointType) {
		super(
				"secgroup",
				"secgroups",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Rules",
						"Is_public",
						"Created_at",
						"Guest_cnt",
						"Description",
						"in_rules",
						"out_rules"
				},
				new String[]{});
	}
}
