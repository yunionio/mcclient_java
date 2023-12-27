package com.yunionyun.mcp.mcclient.managers.impl.billing;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BillingManager;

public class ResourceOrderSetManager extends BillingManager {
	public ResourceOrderSetManager() {
		this(EndpointType.InternalURL);
	}

	public ResourceOrderSetManager(EndpointType endpointType) {
		super(
				"resource_order_set",
				"resource_order_sets",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
