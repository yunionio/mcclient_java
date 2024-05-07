package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class DeploymentManager extends BaseKubeserverManager {
	public DeploymentManager() {
		this(EndpointType.InternalURL);
	}

	public DeploymentManager(EndpointType endpointType) {
		super(
				"deployment",
				"deployments",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
