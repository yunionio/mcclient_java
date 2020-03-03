package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseWebsocketManager;

public class WebsocketManager extends BaseWebsocketManager {

	public WebsocketManager() {
		this(EndpointType.InternalURL);
	}

	public WebsocketManager(EndpointType endpointType) {
		super(
				"websocket",
				"websockets",
				endpointType,
				new String[]{
						"id",
						"obj_id",
						"obj_name",
						"obj_name",
						"priority",
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
