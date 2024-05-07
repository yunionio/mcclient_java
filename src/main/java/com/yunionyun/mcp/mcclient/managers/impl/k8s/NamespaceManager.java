package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class NamespaceManager extends BaseKubeserverManager {
	public NamespaceManager() {
		this(EndpointType.InternalURL);
	}

	public NamespaceManager(EndpointType endpointType) {
		super(
				"namespace",
				"namespaces",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
