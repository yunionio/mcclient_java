package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ProcessDeploymentItsmManager extends BaseITSMManager {
	public ProcessDeploymentItsmManager() {
		this(EndpointType.InternalURL);
	}

	public ProcessDeploymentItsmManager(EndpointType endpointType) {
		super(
				"process-deployment",
				"process-deployments",
				endpointType,
				new String[]{"id", "name", "source", "deployment_time", "tenant_id"},
				new String[]{});
	}
}
