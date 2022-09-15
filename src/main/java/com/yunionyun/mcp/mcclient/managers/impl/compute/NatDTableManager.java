package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NatDTableManager extends ComputeManager {
	public NatDTableManager() {
		this(EndpointType.InternalURL);
	}

	public NatDTableManager(EndpointType endpointType) {
		super(
				"natdentry",
				"natdentries",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Status",
						"Natgateway_Id",
						"Natgateway",
						"External_IP",
						"External_Port",
						"Internal_IP",
						"Internal_Port",
						"Ip_Protocol"
				},
				new String[]{});
	}
}
