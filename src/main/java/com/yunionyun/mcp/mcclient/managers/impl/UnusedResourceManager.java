package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class UnusedResourceManager extends MeterManager {
    public UnusedResourceManager() {
        this(EndpointType.InternalURL);
    }

    public UnusedResourceManager(EndpointType endpointType){
        super("unused_resource", "unused_resources", endpointType,
                new String[]{"res_id", "res_name", "res_type", "start_time", "end_time", "project_name", "spec",
                        "platform", "action", "quantity", "medium_type", "storage_type", "event_id"},
                new String[]{});
    }
}
