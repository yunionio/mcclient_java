package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudeventManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CloudeventManager extends BaseCloudeventManager {
	public CloudeventManager() {
		this(EndpointType.InternalURL);
	}

	public CloudeventManager(EndpointType endpointType) {
		super(
				"cloudevent",
				"cloudevents",
				endpointType,
				new String[]{
						"Action", "Service", "Success", "Resource_Type", "Cloudprovider_Id", "Manager", "Provider"
				},
				new String[]{});
	}
}
