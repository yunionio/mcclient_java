package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ResourceFeeManager extends MeterManager {
	public ResourceFeeManager() {
		this(EndpointType.InternalURL);
	}

	public ResourceFeeManager(EndpointType endpointType) {
		super(
				"resource_fee",
				"resource_fees",
				endpointType,
				new String[]{
						"baremetal_fee",
						"server_fee",
						"gpu_fee",
						"disk_fee",
						"res_fee",
						"item_name",
						"stat_type",
						"stat_month",
						"month_total"
				},
				new String[]{});
	}
}
