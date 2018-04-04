package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

public class HostAlarmRecipientManager extends BaseMonitorManager
{
    
    public HostAlarmRecipientManager()
    {
        super("host_alarm_recipient", "host_alarm_recipients", 
                new String[] { "id", "metric_name", "alarm_condition", "template", "alarm_level", "contact_type", "expire_seconds", "escalate_seconds", "alarm_template_id", "junior_recipients", "senior_recipients", "host_name"}, 
                new String[] {});
    }
}
