package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AssociatedBillManager extends MeterManager {
	public AssociatedBillManager() {
		this(EndpointType.InternalURL);
	}

	public AssociatedBillManager(EndpointType endpointType) {
		super(
				"associated_bill",
				"associated_bills",
				endpointType,
				new String[]{"account", "brand", "resource_id", "resource_name", "amount"},
				new String[]{});
	}
}
