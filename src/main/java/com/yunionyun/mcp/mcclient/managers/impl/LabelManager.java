package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LabelManager extends BaseMonitorManager {
	public LabelManager() {
		this(EndpointType.InternalURL);
	}

	public LabelManager(EndpointType endpointType) {
		super(
				"label",
				"labels",
				endpointType,
				new String[]{
						"ID",
						"label_name",
						"label_value",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"is_deleted",
						"project_id",
						"remark"
				},
				new String[]{});
	}
}
