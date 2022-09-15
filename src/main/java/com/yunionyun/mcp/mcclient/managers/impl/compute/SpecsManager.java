package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SpecsManager extends ComputeManager {
	public SpecsManager() {
		this(EndpointType.InternalURL);
	}

	public SpecsManager(EndpointType endpointType) {
		super("spec", "specs", endpointType, new String[]{}, new String[]{});
	}
}
