package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class TreenodeManager extends BaseMonitorManager {
    public TreenodeManager() {
        this(EndpointType.InternalURL);
    }

    public TreenodeManager(EndpointType endpointType){
        super("tree_node", "tree_nodes", endpointType,
                new String[]{"id", "name", "pid", "order_no", "level", "group", "status", "project_id", "project_type", "create_way", "remark"},
                new String[]{});
    }
}
