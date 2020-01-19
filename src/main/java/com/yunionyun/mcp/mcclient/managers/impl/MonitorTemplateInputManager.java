package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MonitorJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MonitorTemplateInputManager extends MonitorJointManager {
    public MonitorTemplateInputManager(MonitorTemplateManager master, MonitorInputManager slave) {
        this(EndpointType.InternalURL, master, slave);
    }

    public MonitorTemplateInputManager(EndpointType endpointType, MonitorTemplateManager master, MonitorInputManager slave) {
        super("monitorInfo", "monitorInfos", endpointType,
                new String[]{"ID", "monitor_template_id", "monitor_name", "monitor_conf_value", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{}, master, slave);
    }
}
