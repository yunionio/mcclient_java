package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AlarmLogManager extends BaseMonitorManager {
    public AlarmLogManager() {
        this(EndpointType.InternalURL);
    }

    public AlarmLogManager(EndpointType endpointType) {
        super("alarm_log", "alarm_logs",endpointType,
                new String[]{"ID", "node_name", "metric_name", "labels", "start_time", "this_time", "alarm_ways", "alarm_level", "alarm_status", "receive_person", "alarm_release_time", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }


}
