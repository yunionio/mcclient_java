package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AlarmTemplateManager extends BaseMonitorManager {
	public AlarmTemplateManager() {
		this(EndpointType.InternalURL);
	}

	public AlarmTemplateManager(EndpointType endpointType) {
		super(
				"alarm_template",
				"alarm_templates",
				endpointType,
				new String[]{
						"id",
						"alarm_template_name",
						"alarm_template_desc",
						"belongto",
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
