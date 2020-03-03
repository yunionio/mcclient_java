package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ProcessDefinitionItsmManager extends BaseITSMManager {
	public ProcessDefinitionItsmManager() {
		this(EndpointType.InternalURL);
	}

	public ProcessDefinitionItsmManager(EndpointType endpointType) {
		super(
				"process-definition",
				"process-definitions",
				endpointType,
				new String[]{
						"id",
						"name",
						"key",
						"description",
						"resource_name",
						"diagram_resource_name",
						"deployment_id",
						"startable_in_tasklist",
						"category",
						"suspended",
						"start_form_key",
						"history_time_to_live",
						"version",
						"version_tag",
						"tenant_id"
				},
				new String[]{});
	}
}
