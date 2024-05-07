package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class DaemonSetManager extends BaseKubeserverManager {
	public DaemonSetManager() {
		this(EndpointType.InternalURL);
	}

	public DaemonSetManager(EndpointType endpointType) {
		super(
				"daemonset",
				"daemonsets",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
