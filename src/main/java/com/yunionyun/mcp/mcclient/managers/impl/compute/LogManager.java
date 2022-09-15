package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LogManager extends ComputeManager {
	public LogManager() {
		this(EndpointType.InternalURL);
	}

	public LogManager(EndpointType endpointType) {
		super(
				"event",
				"events",
				endpointType,
				new String[]{
						"id",
						"ops_time",
						"obj_id",
						"obj_type",
						"obj_name",
						"user",
						"user_id",
						"tenant",
						"tenant_id",
						"owner_tenant_id",
						"action",
						"notes"
				},
				new String[]{});
	}
}
