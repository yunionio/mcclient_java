package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ServiceAccountManager extends BaseKubeserverManager {
	public ServiceAccountManager() {
		this(EndpointType.InternalURL);
	}

	public ServiceAccountManager(EndpointType endpointType) {
		super(
				"serviceaccount",
				"serviceaccounts",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
