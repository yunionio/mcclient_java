package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class StorageManager extends ComputeManager {
	public StorageManager() {
		this(EndpointType.InternalURL);
	}

	public StorageManager(EndpointType endpointType) {
		super(
				"storage",
				"storages",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Capacity",
						"Status",
						"Used_capacity",
						"Waste_capacity",
						"Free_capacity",
						"Storage_type",
						"Medium_type",
						"Virtual_capacity",
						"commit_bound",
						"commit_rate",
						"Enabled"
				},
				new String[]{});
	}
}
