package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ContainerRegistryManager extends BaseKubeserverManager {
	public ContainerRegistryManager() {
		this(EndpointType.InternalURL);
	}

	public ContainerRegistryManager(EndpointType endpointType) {
		super(
				"container_registry",
				"container_registries",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
