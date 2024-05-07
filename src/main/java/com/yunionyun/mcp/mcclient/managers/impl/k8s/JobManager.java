package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class JobManager extends BaseKubeserverManager {
	public JobManager() {
		this(EndpointType.InternalURL);
	}

	public JobManager(EndpointType endpointType) {
		super(
				"job",
				"jobs",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
