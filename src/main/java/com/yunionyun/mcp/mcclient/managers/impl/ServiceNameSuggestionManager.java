package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ServiceNameSuggestionManager extends BaseMonitorManager {
	public ServiceNameSuggestionManager() {
		this(EndpointType.InternalURL);
	}

	public ServiceNameSuggestionManager(EndpointType endpointType) {
		super(
				"service_name_suggestion",
				"service_name_suggestions",
				endpointType,
				new String[]{"title", "content", "create_by", "gmt_create", "is_deleted"},
				new String[]{});
	}
}
