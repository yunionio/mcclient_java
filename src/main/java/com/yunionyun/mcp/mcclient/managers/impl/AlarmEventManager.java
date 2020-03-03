package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AlarmEventManager extends BaseMonitorManager {
	public AlarmEventManager() {
		this(EndpointType.InternalURL);
	}

	public AlarmEventManager(EndpointType endpointType) {
		super(
				"alarm_event",
				"alarm_events",
				endpointType,
				new String[]{
						"ID",
						"metric_name",
						"host_name",
						"host_ip",
						"alarm_condition",
						"template",
						"first_alarm_time",
						"last_alarm_time",
						"alarm_status",
						"alarm_times",
						"ack_time",
						"ack_status",
						"ack_wait_time",
						"upgrade_time",
						"upgrade_status",
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

	public JSONObject DoBatchUpdate(Session session, JSONObject body)
			throws JSONClientException, McClientJavaBizException, IOException {
		return _put(session, "/alarm_events", body, "alarm_events");
	}
}
