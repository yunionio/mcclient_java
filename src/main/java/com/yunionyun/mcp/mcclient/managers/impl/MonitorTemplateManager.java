package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MonitorTemplateManager extends BaseMonitorManager {
	public MonitorTemplateManager() {
		this(EndpointType.InternalURL);
	}

	public MonitorTemplateManager(EndpointType endpointType) {
		super(
				"monitor_template",
				"monitor_templates",
				endpointType,
				new String[]{
						"ID",
						"monitor_template_name",
						"monitor_template_desc",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"is_deleted",
						"project_id",
						"remark"
				},
				new String[]{});
	}
}
