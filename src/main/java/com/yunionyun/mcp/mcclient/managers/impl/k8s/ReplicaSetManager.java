package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ReplicaSetManager extends BaseKubeserverManager {
	public ReplicaSetManager() {
		this(EndpointType.InternalURL);
	}

	public ReplicaSetManager(EndpointType endpointType) {
		super(
				"replicaset",
				"replicasets",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
