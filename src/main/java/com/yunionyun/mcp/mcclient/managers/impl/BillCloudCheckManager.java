package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BillCloudCheckManager extends MeterManager {
	public BillCloudCheckManager() {
		this(EndpointType.InternalURL);
	}

	public BillCloudCheckManager(EndpointType endpointType) {
		super(
				"bill_cloudcheck",
				"bill_cloudchecks",
				endpointType,
				new String[]{
						"provider",
						"account_id",
						"sum_month",
						"res_type",
						"res_id",
						"res_name",
						"external_id",
						"cloud_fee",
						"kvm_fee",
						"diff_fee",
						"diff_percent"
				},
				new String[]{});
	}
}
