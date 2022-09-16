package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class WireManager extends ComputeManager {
	public WireManager() {
		this(EndpointType.InternalURL);
	}

	public WireManager(EndpointType endpointType) {
		super(
				"wire",
				"wires",
				endpointType,
				new String[]{"ID", "Name", "Bandwidth", "Zone_ID", "Zone", "Networks", "VPC", "VPC_ID"},
				new String[]{});
	}
}
