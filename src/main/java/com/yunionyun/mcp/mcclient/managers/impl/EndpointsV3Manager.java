package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class EndpointsV3Manager extends KeystoneManager {
	public EndpointsV3Manager() {
		this(EndpointType.AdminURL);
	}

	public EndpointsV3Manager(EndpointType endpointType) {
		super(
				"endpoint",
				"endpoints",
				endpointType,
				new String[]{},
				new String[]{
						"ID",
						"Region_ID",
						"Service",
						"Service_ID",
						"Service_Name",
						"Service_Type",
						"URL",
						"Interface",
						"Enabled"
				});
	}
}
