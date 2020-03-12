package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BillAnalysiseManager extends MeterManager {
	public BillAnalysiseManager() {
		this(EndpointType.InternalURL);
	}

	public BillAnalysiseManager(EndpointType endpointType) {
		super(
				"bill_analysis",
				"bill_analysises",
				endpointType,
				new String[]{"stat_date", "stat_value", "res_name", "res_type", "project_name", "res_fee"},
				new String[]{});
	}
}
