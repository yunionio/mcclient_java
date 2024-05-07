package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class ResourceQuotaManager extends BaseKubeserverManager {
	public ResourceQuotaManager() {
		this(EndpointType.InternalURL);
	}

	public ResourceQuotaManager(EndpointType endpointType) {
		super(
				"resourcequota",
				"resourcequotas",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
