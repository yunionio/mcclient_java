package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class HistoricTaskInstanceItsmManager extends BaseITSMManager {
	public HistoricTaskInstanceItsmManager() {
		this(EndpointType.InternalURL);
	}

	public HistoricTaskInstanceItsmManager(EndpointType endpointType) {
		super(
				"historic-task-instance",
				"historic-task-instances",
				endpointType,
				new String[]{
						"id",
						"name",
						"parent_task_id",
						"duration_in_millis",
						"description",
						"case_execution_id",
						"removal_time",
						"delete_reason",
						"follow_up_date",
						"execution_id",
						"activity_instance_id",
						"root_process_instance_id",
						"owner",
						"process_definition_key",
						"end_time",
						"due_date",
						"super_case_instance_id",
						"priority",
						"process_definition_id",
						"start_time",
						"case_definition_key",
						"case_instance_id",
						"process_instance_id",
						"case_definition_id",
						"assignee",
						"task_definition_key"
				},
				new String[]{});
	}
}
