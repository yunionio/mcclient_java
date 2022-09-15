package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SnapshotPolicyCacheManager extends ComputeManager {
	public SnapshotPolicyCacheManager() {
		this(EndpointType.InternalURL);
	}

	public SnapshotPolicyCacheManager(EndpointType endpointType) {
		super(
				"snapshotpolicycache",
				"snapshotpolicycaches",
				endpointType,
				new String[]{"Snapshotpolicy_Id", "External_Id", "Cloudregion_Id", "Manager_Id"},
				new String[]{});
	}
}
