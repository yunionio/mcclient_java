package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseLogActionManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BaremetalEventManager extends BaseLogActionManager {
	public BaremetalEventManager() {
		this(EndpointType.InternalURL);
	}

	public BaremetalEventManager(EndpointType endpointType) {
		super(
				"baremetalevent",
				"baremetalevents",
				endpointType,
				new String[]{
						"id",
						"host_id",
						"host_name",
						"ipmi_ip",
						"created",
						"event_id",
						"message",
						"severity",
						"type"
				},
				new String[]{});
	}
}
