package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class PodManager extends BaseKubeserverManager {
	public PodManager() {
		this(EndpointType.InternalURL);
	}

	public PodManager(EndpointType endpointType) {
		super(
				"pod",
				"pods",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
