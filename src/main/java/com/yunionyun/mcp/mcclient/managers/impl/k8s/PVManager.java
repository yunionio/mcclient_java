package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class PVManager extends BaseKubeserverManager {
	public PVManager() {
		this(EndpointType.InternalURL);
	}

	public PVManager(EndpointType endpointType) {
		super(
				"persistentvolume",
				"persistentvolumes",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
