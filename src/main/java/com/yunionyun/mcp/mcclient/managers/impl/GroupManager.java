package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

public class GroupManager extends KeystoneManager {
	public GroupManager() {
		this(EndpointType.AdminURL);
	}

	public GroupManager(EndpointType endpointType) {
		super(
				"group",
				"groups",
				endpointType,
				new String[]{"ID", "Name", "Domain_Id", "Description"},
				new String[]{});
	}

	public ListResult getGroupUserList(Session s, String groupId) {
		if (groupId != null && !"".equals(groupId) && groupId.length() > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("/groups/");
			builder.append(groupId);
			builder.append("/users");

			try {
				ListResult list = _list(s, builder.toString(), "users");
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
