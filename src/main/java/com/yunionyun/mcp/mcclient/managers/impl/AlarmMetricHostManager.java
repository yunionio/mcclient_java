package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

public class AlarmMetricHostManager extends BaseMonitorManager {

    public AlarmMetricHostManager() {
        this(EndpointType.InternalURL);
    }

    public AlarmMetricHostManager(EndpointType endpointType) {
        super("alarm_metric_host", "alarm_metric_hosts", endpointType,
                new String[]{"id", "metric_name", "alarm_condition", "template", "alarm_level", "contact_type", "expire_seconds", "escalate_seconds", "alarm_template_id", "nodeLabels", "host_id", "host_name", "host_ip"},
                new String[]{});
    }
}
