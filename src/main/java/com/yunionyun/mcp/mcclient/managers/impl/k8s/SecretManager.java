package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class SecretManager extends BaseKubeserverManager {
	public SecretManager() {
		this(EndpointType.InternalURL);
	}

	public SecretManager(EndpointType endpointType) {
		super(
				"secret",
				"secrets",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
