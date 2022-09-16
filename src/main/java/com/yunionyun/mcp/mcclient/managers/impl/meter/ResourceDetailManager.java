package com.yunionyun.mcp.mcclient.managers.impl.meter;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ResourceDetailManager extends MeterManager {
	public ResourceDetailManager() {
		this(EndpointType.InternalURL);
	}

	public ResourceDetailManager(EndpointType endpointType) {
		super(
				"resource_detail",
				"resource_details",
				endpointType,
				new String[]{
						"res_type",
						"res_id",
						"res_name",
						"start_time",
						"end_time",
						"project_name",
						"user_name",
						"res_fee"
				},
				new String[]{});
	}
}
