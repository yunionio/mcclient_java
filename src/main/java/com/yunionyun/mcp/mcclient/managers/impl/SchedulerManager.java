package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseSchedulerManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedulerManager extends BaseSchedulerManager {
    public SchedulerManager() {
        this(EndpointType.InternalURL);
    }

    public SchedulerManager(EndpointType endpointType) {
        super("scheduler", "schedulers", endpointType,
        new String[]{}, new String[]{});
    }
}
