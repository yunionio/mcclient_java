package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ServiceTreeManager extends BaseMonitorManager {
    public ServiceTreeManager() {
        this(EndpointType.InternalURL);
    }

    public ServiceTreeManager(EndpointType endpointType){
        super("service_tree", "service_trees", endpointType,
                new String[]{"id", "service_tree_name", "service_tree_struct", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }
}
