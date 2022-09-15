package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CloudproviderregionManager extends ComputeJointManager {
	public CloudproviderregionManager(CloudProviderManager master, CloudregionManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public CloudproviderregionManager(
			EndpointType endpointType, CloudProviderManager master, CloudregionManager slave) {
		super(
				"cloudproviderregion",
				"cloudproviderregions",
				endpointType,
				new String[]{
						"Cloudaccount_ID",
						"Cloudaccount",
						"Cloudprovider_ID",
						"CloudProvider",
						"Cloudregion_ID",
						"CloudRegion",
						"Enabled",
						"Sync_Status",
						"Last_Sync",
						"Last_Sync_End_At",
						"Auto_Sync",
						"last_deep_sync_at",
						"Sync_Results"
				},
				new String[]{},
				master,
				slave);
	}
}
