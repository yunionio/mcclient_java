package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MonitorManager;

/**
 * @author qx
 * @date 2022/09/15
 */
public class UnifiedMonitorManager extends MonitorManager {
    public UnifiedMonitorManager() {
        this(EndpointType.InternalURL);
    }

    public UnifiedMonitorManager(EndpointType endpointType) {
        super(
                "unifiedmonitor",
                "unifiedmonitors",
                endpointType,
                new String[]{},
                new String[]{});
    }
}
