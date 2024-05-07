package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class StorageClassManager extends BaseKubeserverManager {
	public StorageClassManager() {
		this(EndpointType.InternalURL);
	}

	public StorageClassManager(EndpointType endpointType) {
		super(
				"storageclass",
				"storageclasses",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
