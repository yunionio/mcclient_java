package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ProjectAdminCandidateManager extends BaseMonitorManager {
	public ProjectAdminCandidateManager() {
		this(EndpointType.InternalURL);
	}

	public ProjectAdminCandidateManager(EndpointType endpointType) {
		super(
				"project_admin_candidate",
				"project_admin_candidates",
				endpointType,
				new String[]{"id", "name"},
				new String[]{});
	}
}
