package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class InstanceItsmManager extends BaseITSMManager {
	public InstanceItsmManager() {
		this(EndpointType.InternalURL);
	}

	public InstanceItsmManager(EndpointType endpointType) {
		super(
				"instance",
				"instances",
				endpointType,
				new String[]{
						"id",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"is_deleted",
						"project_id",
						"remark",
						"apply_date",
						"instance_id",
						"business_id",
						"procdef_key",
						"busi_type",
						"apply_unit",
						"client_info",
						"emergency",
						"impact",
						"title",
						"content",
						"start_time",
						"end_time",
						"starter",
						"starter_name",
						"instance_status",
						"current_approver",
						"approver_name",
						"task_name",
						"task_type",
						"task_id",
						"result",
						"login_name",
						"common_start_string"
				},
				new String[]{
						"id",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"is_deleted",
						"project_id",
						"remark",
						"apply_date",
						"instance_id",
						"business_id",
						"procdef_key",
						"busi_type",
						"apply_unit",
						"client_info",
						"emergency",
						"impact",
						"title",
						"content",
						"start_time",
						"end_time",
						"starter",
						"starter_name",
						"instance_status",
						"current_approver",
						"approver_name",
						"task_name",
						"task_type",
						"task_id",
						"result",
						"login_name",
						"common_start_string"
				});
	}
}
