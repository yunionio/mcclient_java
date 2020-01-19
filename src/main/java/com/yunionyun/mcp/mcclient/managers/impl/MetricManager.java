package com.yunionyun.mcp.mcclient.managers.impl;

import com.sun.corba.se.spi.monitoring.MonitoringManager;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.keystone.Endpoint;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MetricManager extends BaseMonitorManager {
    public MetricManager() {
        this(EndpointType.InternalURL);
    }

    public MetricManager(EndpointType endpointType){
        super("metric", "metrics", endpointType,
                new String[]{"id", "name", "description", "unit", "common_unit", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }
}
