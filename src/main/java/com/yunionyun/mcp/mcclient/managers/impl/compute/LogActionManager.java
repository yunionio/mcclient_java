package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseLogActionManager;

public class LogActionManager extends BaseLogActionManager {

	public LogActionManager() {
		this(EndpointType.InternalURL);
	}

	public LogActionManager(EndpointType endpointType) {
		super(
				"action",
				"actions",
				endpointType,
				new String[]{
						"obj_type",
						"obj_id",
						"obj_name",
						"success",
						"action",
						"notes",
						"user_id",
						"user",
						"tenant_id",
						"tenant"
				},
				new String[]{});
	}
}
