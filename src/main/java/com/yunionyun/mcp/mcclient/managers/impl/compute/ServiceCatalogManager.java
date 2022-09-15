package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ServiceCatalogManager extends ComputeManager {
	public ServiceCatalogManager() {
		this(EndpointType.InternalURL);
	}

	public ServiceCatalogManager(EndpointType endpointType) {
		super(
				"servicecatalog",
				"servicecatalogs",
				endpointType,
				new String[]{"ID", "Name", "Public_Scope", "Is_Public", "Icon_Url", "Guest_Template_ID"},
				new String[]{});
	}
}
