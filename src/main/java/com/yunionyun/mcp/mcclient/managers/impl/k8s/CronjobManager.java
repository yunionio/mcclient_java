package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class CronjobManager extends BaseKubeserverManager {
	public CronjobManager() {
		this(EndpointType.InternalURL);
	}

	public CronjobManager(EndpointType endpointType) {
		super(
				"cronjob",
				"cronjobs",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
