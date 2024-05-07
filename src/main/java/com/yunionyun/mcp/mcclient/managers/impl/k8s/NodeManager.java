package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class NodeManager extends BaseKubeserverManager {
	public NodeManager() {
		this(EndpointType.InternalURL);
	}

	public NodeManager(EndpointType endpointType) {
		super(
				"k8s_node",
				"k8s_nodes",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
