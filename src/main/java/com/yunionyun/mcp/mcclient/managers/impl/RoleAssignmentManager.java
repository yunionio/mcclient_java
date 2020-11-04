package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.entitys.RoleAssignmentsListInput;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.ResourceManager;

import java.io.IOException;

public class RoleAssignmentManager extends KeystoneManager {
	public RoleAssignmentManager() {
		this(EndpointType.AdminURL);
	}

	public RoleAssignmentManager(EndpointType endpointType) {
		super(
				"role_assignment",
				"role_assignments",
				endpointType,
				new String[]{"Scope", "User", "Group", "Role"},
				new String[]{});
	}


	public ListResult List(Session s, RoleAssignmentsListInput input) throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject query = new JSONObject();
		query.put("include_names", null);
		if (input.getEffective()) {
			query.put("effective", input.getEffective());
		}
		if (input.getSystem()) {
			query.put("include_system", input.getSystem());
		}
		if (input.getPolicy()) {
			query.put("include_policies", input.getPolicy());
		}
		if (input.getDomain().length() > 0) {
			String domainId = getDomaintId(s, input.getDomain());
			query.put("scope", JSONObject.parse(JSONObject.toJSONString(newScopeJsonObj("domain", domainId))));
		}
		if (input.getProject().length() > 0) {
			String projectId = getManagerBaseId(s, input.getProject(), input.getProjectDomain(), new ProjectManager(this.getEndpontType()));
			query.put("scope", JSONObject.parse(JSONObject.toJSONString(newScopeJsonObj("project", projectId))));
		}
		if (input.getUser().length() > 0) {
			String userId = getManagerBaseId(s, input.getUser(), input.getUserDomain(), new UserManager(this.getEndpontType()));
			query.put("user", JSONObject.parse(JSONObject.toJSONString(newIdJsonObj(userId))));
		}
		if (input.getGroup().length() > 0) {
			String groupId = getManagerBaseId(s, input.getGroup(), input.getGroupDomain(), new GroupManager(this.getEndpontType()));
			query.put("group", newIdJsonObj(groupId));
		}
		if (input.getRole().length() > 0) {
			String roleId = getManagerBaseId(s, input.getRole(), input.getRoleDomain(), new RoleManager(this.getEndpontType()));
			query.put("role", JSONObject.parse(JSONObject.toJSONString(newIdJsonObj(roleId))));
		}
		if (input.getUsers().length > 0) {
			query.put("users", JSONObject.parseArray(JSONObject.toJSONString(input.getUsers())));
		}
		if (input.getGroups().length > 0) {
			query.put("groups", JSONObject.parseArray(JSONObject.toJSONString(input.getGroups())));
		}
		if (input.getRoles().length > 0) {
			query.put("roles", JSONObject.parseArray(JSONObject.toJSONString(input.getRoles())));
		}
		if (input.getProjects().length > 0) {
			query.put("projects", JSONObject.parseArray(JSONObject.toJSONString(input.getProjects())));
		}
		if (input.getDomains().length > 0) {
			query.put("domains", JSONObject.parseArray(JSONObject.toJSONString(input.getDomains())));
		}
		if (input.getProjectDomains().length > 0) {
			query.put("project_domains", JSONObject.parseArray(JSONObject.toJSONString(input.getProjectDomains())));
		}
		if (input.getLimit() >= 0) {
			query.put("limit", input.getLimit());
		}
		if (input.getOffset() >= 0) {
			query.put("offset", input.getOffset());
		}
		return super.List(s, query);
	}

	private String getManagerBaseId(Session s, String project, String domain, ResourceManager manager) throws JSONClientException, McClientJavaBizException, IOException {
		JSONObject query = new JSONObject();
		if (domain.length() > 0) {
			String domaimId = getDomaintId(s, domain);
			query.put("domain_id", domaimId);
		}
		JSONObject baseObj = manager.GetById(s, project, query);
		return baseObj.getString("id");
	}

	private String getDomaintId(Session s, String domain) throws JSONClientException, McClientJavaBizException, IOException {
		JSONObject query = new JSONObject();
		DomainManager domainManager = new DomainManager(this.getEndpontType());
		JSONObject domainObj = domainManager.GetById(s, domain, new JSONObject());
		return domainObj.getString("id");
	}

	private JSONObject newIdJsonObj(String id) {
		JSONObject idObj = new JSONObject();
		idObj.put("id", id);
		return idObj;
	}

	private JSONObject newScopeJsonObj(String resource, String id) {
		JSONObject scopeObj = new JSONObject();
		scopeObj.put(resource, newIdJsonObj(id));
		return scopeObj;
	}


}
