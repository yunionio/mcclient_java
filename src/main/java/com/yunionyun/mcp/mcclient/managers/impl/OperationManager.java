package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class OperationManager extends BaseITSMManager {
	public OperationManager() {
		this(EndpointType.InternalURL);
	}

	public OperationManager(EndpointType endpointType) {
		super(
				"operation",
				"operations",
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
						"instance_id",
						"business_id",
						"operate_type",
						"template_id",
						"device_code",
						"ip_address",
						"cpu",
						"memery",
						"disk",
						"resource_sum",
						"network",
						"schedule",
						"login_name",
						"display_name",
						"resource_ids",
						"instance",
						"task",
						"log_list",
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
						"instance_id",
						"business_id",
						"operate_type",
						"template_id",
						"device_code",
						"ip_address",
						"cpu",
						"memery",
						"disk",
						"resource_sum",
						"network",
						"schedule",
						"login_name",
						"display_name",
						"resource_ids",
						"instance",
						"task",
						"log_list",
						"common_start_string"
				});
	}
}
