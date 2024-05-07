package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class PVCManager extends BaseKubeserverManager {
	public PVCManager() {
		this(EndpointType.InternalURL);
	}

	public PVCManager(EndpointType endpointType) {
		super(
				"persistentvolumeclaim",
				"persistentvolumeclaims",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
