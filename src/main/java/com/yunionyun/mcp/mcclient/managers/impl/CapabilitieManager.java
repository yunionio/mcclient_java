package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CapabilitieManager extends ComputeManager {
	public CapabilitieManager() {
		this(EndpointType.InternalURL);
	}

	public CapabilitieManager(EndpointType endpointType) {
		super("capability", "capabilities", endpointType, new String[]{}, new String[]{});
	}
}
