package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class ZoneManager extends ComputeManager {
	public ZoneManager() {
		this(EndpointType.InternalURL);
	}

	public ZoneManager(EndpointType endpointType) {
		super(
				"zone",
				"zones",
				endpointType,
				new String[]{
						"ID", "Name", "Name_CN", "Status", "Cloudregion_ID", "CloudRegion", "Location"
				},
				new String[]{"Manager_URI"});
	}
}
