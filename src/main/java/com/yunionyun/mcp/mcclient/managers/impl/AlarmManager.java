package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AlarmManager extends BaseMonitorManager {
    public AlarmManager() {
        this(EndpointType.InternalURL);
    }

    public AlarmManager(EndpointType endpointType) {
        super("alarm", "alarms",endpointType,
                new String[]{"id", "metric_name", "unit", "common_unit", "alarm_condition", "template", "alarm_level", "contact_type", "expire_seconds", "escalate_seconds", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }
}
