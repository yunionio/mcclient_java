package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ServiceManager extends BaseKubeserverManager {
	public ServiceManager() {
		this(EndpointType.InternalURL);
	}

	public ServiceManager(EndpointType endpointType) {
		super(
				"k8s_service",
				"k8s_services",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
