package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class HistoricProcessInstanceItsmManager extends BaseITSMManager {
	public HistoricProcessInstanceItsmManager() {
		this(EndpointType.InternalURL);
	}

	public HistoricProcessInstanceItsmManager(EndpointType endpointType) {
		super(
				"historic-process-instance",
				"historic-process-instances",
				endpointType,
				new String[]{
						"id",
						"process_definition_key",
						"start_activity_id",
						"end_time",
						"duration_in_millis",
						"removal_time",
						"business_key",
						"end_activity_id",
						"process_definition_version",
						"delete_reason",
						"process_definition_id",
						"start_time",
						"start_user_id",
						"case_instance_id",
						"root_process_instance_id",
						"super_case_instance_id",
						"state",
						"process_definition_name",
						"super_process_instance_id",
						"tenant_id"
				},
				new String[]{});
	}
}
