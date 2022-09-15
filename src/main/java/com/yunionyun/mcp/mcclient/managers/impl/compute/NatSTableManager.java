package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NatSTableManager extends ComputeManager {
	public NatSTableManager() {
		this(EndpointType.InternalURL);
	}

	public NatSTableManager(EndpointType endpointType) {
		super(
				"natsentry",
				"natsentries",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Status",
						"IP",
						"Natgateway_Id",
						"Natgateway",
						"Network",
						"Network_Id",
						"Source_CIDR"
				},
				new String[]{});
	}
}
