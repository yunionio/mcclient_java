package com.yunionyun.mcp.mcclient.managers.impl.meter;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CloudSkuRateManager extends MeterManager {
	public CloudSkuRateManager() {
		this(EndpointType.InternalURL);
	}

	public CloudSkuRateManager(EndpointType endpointType) {
		super(
				"cloud_sku_rate",
				"cloud_sku_rates",
				endpointType,
				new String[]{"id", "data_id", "data_key", "hour_price", "month_price", "year_price"},
				new String[]{});
	}
}
