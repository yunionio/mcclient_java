package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ReleaseManager extends BaseKubeserverManager {
	public ReleaseManager() {
		this(EndpointType.InternalURL);
	}

	public ReleaseManager(EndpointType endpointType) {
		super(
				"release",
				"releases",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
