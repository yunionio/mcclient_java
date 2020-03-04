package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MonitorJointManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AlarmTemplateAlarmManager extends MonitorJointManager {
	public AlarmTemplateAlarmManager(AlarmTemplateManager master, AlarmManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public AlarmTemplateAlarmManager(
			EndpointType endpointType, AlarmTemplateManager master, AlarmManager slave) {
		super(
				"alarmtemplate_alarm",
				"alarmtemplate_alarms",
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
				new String[]{},
				master,
				slave);
	}
}
