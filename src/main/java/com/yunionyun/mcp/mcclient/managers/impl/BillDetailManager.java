package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BillDetailManager extends MeterManager {
	public BillDetailManager() {
		this(EndpointType.InternalURL);
	}

	public BillDetailManager(EndpointType endpointType) {
		super(
				"bill_detail",
				"bill_details",
				endpointType,
				new String[]{
						"bill_id",
						"account",
						"platform",
						"region",
						"manager_project",
						"res_id",
						"res_type",
						"res_name",
						"start_time",
						"end_time",
						"charge_type",
						"item_rate",
						"item_fee"
				},
				new String[]{});
	}
}
