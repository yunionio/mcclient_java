package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ServiceNodeManager extends BaseMonitorManager {
	public ServiceNodeManager() {
		this(EndpointType.InternalURL);
	}

	public ServiceNodeManager(EndpointType endpointType) {
		super(
				"service_host",
				"service_hosts",
				endpointType,
				new String[]{
						"id",
						"host_id",
						"host_name",
						"ip",
						"vcpu_count",
						"vmem_size",
						"disk",
						"project",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"project_id",
						"remark"
				},
				new String[]{});
	}
}
