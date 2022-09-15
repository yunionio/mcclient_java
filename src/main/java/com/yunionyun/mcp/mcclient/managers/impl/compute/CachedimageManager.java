package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CachedimageManager extends ComputeManager {
	public CachedimageManager() {
		this(EndpointType.InternalURL);
	}

	public CachedimageManager(EndpointType endpointType) {
		super(
				"cachedimage",
				"cachedimages",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Size",
						"Format",
						"Owner",
						"OS_Type",
						"OS_Distribution",
						"OS_version",
						"Hypervisor",
						"Host_count",
						"Status",
						"Ref_Count",
						"cached_count",
						"image_type",
						"External_Id"
				},
				new String[]{});
	}
}
