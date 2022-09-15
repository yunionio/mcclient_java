package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class VpcsManager extends ComputeManager {
	public VpcsManager() {
		this(EndpointType.InternalURL);
	}

	public VpcsManager(EndpointType endpointType) {
		super(
				"vpc",
				"vpcs",
				endpointType,
				new String[]{
						"ID", "Name", "Enabled", "Status", "Cloudregion_Id", "Is_default", "Cidr_Block", "Region"
				},
				new String[]{});
	}
}
