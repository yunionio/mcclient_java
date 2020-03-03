package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ProjectAdminManager extends BaseMonitorManager {
	public ProjectAdminManager() {
		this(EndpointType.InternalURL);
	}

	public ProjectAdminManager(EndpointType endpointType) {
		super(
				"project_admin",
				"project_admins",
				endpointType,
				new String[]{
						"create_by",
						"gmt_create",
						"id",
						"is_deleted",
						"node_labels",
						"officer_id",
						"officer_name",
						"type",
						"domain"
				},
				new String[]{});
	}
}
