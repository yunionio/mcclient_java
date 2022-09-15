package com.yunionyun.mcp.mcclient.managers.impl.meter;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2021/07/30
 */
public class BillingExchangeRateManager extends MeterManager {
	public BillingExchangeRateManager() {
		this(EndpointType.InternalURL);
	}

	public BillingExchangeRateManager(EndpointType endpointType) {
		super(
				"billing_exchange_rate",
				"billing_exchange_rates",
				endpointType,
				new String[]{
						"src",
						"dest",
						"rate",
						"date",
				},
				new String[]{});
	}
}
