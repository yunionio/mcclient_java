package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseLogActionManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class ActionManager extends BaseLogActionManager {
	public ActionManager() {
		this(EndpointType.InternalURL);
	}

	public ActionManager(EndpointType endpointType) {
		super(
				"action",
				"actions",
				endpointType,
				new String[]{
						"id",
						"start_time",
						"service",
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
						"success",
						"notes"
				},
				new String[]{});
	}
}
