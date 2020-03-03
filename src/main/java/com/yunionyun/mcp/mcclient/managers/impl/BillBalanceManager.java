package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

public class BillBalanceManager extends MeterManager {
	public BillBalanceManager() {
		this(EndpointType.InternalURL);
	}

	public BillBalanceManager(EndpointType endpointType) {
		super(
				"bill_balance",
				"bill_balances",
				endpointType,
				new String[]{"ID", "account", "account_name", "balance", "provider", "status"},
				new String[]{});
	}
}
