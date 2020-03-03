package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class IsolatedDeviceManager extends ComputeManager {
	public IsolatedDeviceManager() {
		this(EndpointType.InternalURL);
	}

	public IsolatedDeviceManager(EndpointType endpointType) {
		super(
				"isolated_device",
				"isolated_devices",
				endpointType,
				new String[]{
						"ID",
						"Dev_type",
						"Model",
						"Addr",
						"Vendor_device_id",
						"Host_id",
						"Host",
						"Guest_id",
						"Guest",
						"Guest_status"
				},
				new String[]{});
	}
}
