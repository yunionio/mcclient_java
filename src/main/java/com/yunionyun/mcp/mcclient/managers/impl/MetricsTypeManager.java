package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MetricsTypeManager extends BaseMonitorManager {
    public MetricsTypeManager() {
        this(EndpointType.InternalURL);
    }

    public MetricsTypeManager(EndpointType endpointType){
        super("metric_type", "metric_types", endpointType,
                new String[]{"id", "name", "description", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }
}
