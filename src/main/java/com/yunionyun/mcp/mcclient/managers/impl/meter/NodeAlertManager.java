package com.yunionyun.mcp.mcclient.managers.impl.meter;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMeterAlertManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NodeAlertManager extends BaseMeterAlertManager {
	public NodeAlertManager() {
		this(EndpointType.InternalURL);
	}

	public NodeAlertManager(EndpointType endpointType) {
		super(
				"nodealert",
				"nodealerts",
				endpointType,
				new String[]{
						"id",
						"type",
						"metric",
						"node_name",
						"node_id",
						"period",
						"window",
						"comparator",
						"threshold",
						"recipients",
						"level",
						"channel",
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
