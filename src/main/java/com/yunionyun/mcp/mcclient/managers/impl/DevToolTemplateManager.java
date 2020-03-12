package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseDevtoolManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DevToolTemplateManager extends BaseDevtoolManager {
	public DevToolTemplateManager() {
		this(EndpointType.InternalURL);
	}

	public DevToolTemplateManager(EndpointType endpointType) {
		super(
				"devtool_template",
				"devtool_templates",
				endpointType,
				new String[]{
						"id",
						"name",
						"domain_id",
						"tenant_id",
						"day",
						"hour",
						"min",
						"sec",
						"interval",
						"start",
						"enabled",
						"description"
				},
				new String[]{"is_system"});
	}
}
