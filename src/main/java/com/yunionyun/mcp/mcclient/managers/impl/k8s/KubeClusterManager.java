package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class KubeClusterManager extends BaseKubeserverManager {
	public KubeClusterManager() {
		this(EndpointType.InternalURL);
	}

	public KubeClusterManager(EndpointType endpointType) {
		super(
				"kubecluster",
				"kubeclusters",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
