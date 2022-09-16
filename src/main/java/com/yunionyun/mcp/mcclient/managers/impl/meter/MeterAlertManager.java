package com.yunionyun.mcp.mcclient.managers.impl.meter;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMeterAlertManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MeterAlertManager extends BaseMeterAlertManager {
	public MeterAlertManager() {
		this(EndpointType.InternalURL);
	}

	public MeterAlertManager(EndpointType endpointType) {
		super(
				"meteralert",
				"meteralerts",
				endpointType,
				new String[]{
						"id",
						"type",
						"provider",
						"account",
						"account_id",
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
