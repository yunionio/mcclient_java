package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

public class UserManager extends KeystoneManager {
	public UserManager() {
		this(EndpointType.AdminURL);
	}

	public UserManager(EndpointType endpointType) {
		super(
				"user",
				"users",
				endpointType,
				new String[]{},
				new String[]{"ID", "Name", "Domain_Id", "Enabled", "Email", "Mobile"});
	}

	public ListResult getProjects(Session s, String uId) {
		String url = "/users/" + uId + "/projects";
		try {
			return this._list(s, url, "projects");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ListResult getGroups(Session s, String uId) {
		String url = "/users/" + uId + "/groups";
		try {
			return this._list(s, url, "groups");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * /v3/projects/{project_id}/users/{user_id}/roles/{role_id} Assign role to user on project see
	 * detail: https://developer.openstack.org/api-ref/identity/v3/#unassign-role-from-user-on-project
	 *
	 * @param s
	 * @param domainId
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public JSONObject assignRoleToUserOnProject(
			Session s, String projectId, String userId, String roleId) {
		String url = "/projects/" + projectId + "/users/" + userId + "/roles/" + roleId;
		try {
			return this._put(s, url, null, this.keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * /v3/projects/{project_id}/users/{user_id}/roles/{role_id} Unassign role from user on project
	 *
	 * @param s
	 * @param domainId
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public JSONObject unassignRoleFromUserOnProject(
			Session s, String projectId, String userId, String roleId) {
		String url = "/projects/" + projectId + "/users/" + userId + "/roles/" + roleId;
		try {
			return this._delete(s, url, null, this.keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 */
}
