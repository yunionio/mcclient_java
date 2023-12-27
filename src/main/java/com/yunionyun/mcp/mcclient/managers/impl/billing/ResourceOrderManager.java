package com.yunionyun.mcp.mcclient.managers.impl.billing;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BillingManager;

public class ResourceOrderManager extends BillingManager {
	public ResourceOrderManager() {
		 this(EndpointType.InternalURL);
	}

	public ResourceOrderManager(EndpointType endpointType) {
		 super(
				 "resource_order",
				 "resource_orders",
				 endpointType,
				 new String[]{},
				 new String[]{});
	}
}
