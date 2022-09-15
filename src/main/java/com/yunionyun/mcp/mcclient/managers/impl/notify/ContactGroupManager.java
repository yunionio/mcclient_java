package com.yunionyun.mcp.mcclient.managers.impl.notify;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ContactGroupManager extends BaseNotifyManager {
	public ContactGroupManager() {
		this(EndpointType.InternalURL);
	}

	public ContactGroupManager(EndpointType endpointType) {
		super(
				"contact-group",
				"contact-groups",
				endpointType,
				new String[]{
						"id",
						"name",
						"domain_id",
						"domain_name",
						"members",
						"status",
						"create_by",
						"update_by",
						"delete_by",
						"gmt_create",
						"gmt_modified",
						"gmt_delete",
						"project_id",
						"remark"
				},
				new String[]{});
	}
}
