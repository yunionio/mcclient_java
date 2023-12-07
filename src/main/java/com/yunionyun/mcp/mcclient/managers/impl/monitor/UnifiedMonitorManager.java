package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.MonitorManager;

import java.io.IOException;

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

    public JSONObject PerformQuery(Session session, MetricQueryInput input) throws JSONClientException, McClientJavaBizException, IOException {
        return this.PerformClassAction(session, "query", input.toJSONObject());
    }
}
