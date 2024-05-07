package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class IngressManager extends BaseKubeserverManager {
	public IngressManager() {
		this(EndpointType.InternalURL);
	}

	public IngressManager(EndpointType endpointType) {
		super(
				"ingress",
				"ingresses",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
