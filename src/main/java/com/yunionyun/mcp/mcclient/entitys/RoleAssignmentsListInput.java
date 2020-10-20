package com.yunionyun.mcp.mcclient.entitys;

/**
 * @author zxc
 * @date 2020/10/14
 */

public class RoleAssignmentsListInput {
	private boolean effective;
	private boolean system;
	private boolean policy;

	private String domain;
	private String user;
	private String userDomain;
	private String group;
	private String groupDomain;
	private String project;
	private String projectDomain;
	private String role;
	private String roleDomain;
	private int limit;
	private int offset;
	private String[] users;
	private String[] groups;
	private String[] roles;
	private String[] projects;
	private String[] domains;

	public RoleAssignmentsListInput() {
		this.effective = true;
		this.system = false;
		this.policy = false;

		this.domain = "";
		this.user = "";
		this.userDomain = "";
		this.group = "";
		this.groupDomain = "";
		this.project = "";
		this.projectDomain = "";
		this.role = "";
		this.roleDomain = "";

		this.limit = 20;
		this.users = new String[]{};
		this.groups = new String[]{};
		this.roles = new String[]{};
		this.projects = new String[]{};
		this.domains = new String[]{};
	}

	public boolean getEffective() {
		return effective;
	}

	public void setEffective(boolean effective) {
		this.effective = effective;
	}

	public boolean getSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public boolean getPolicy() {
		return policy;
	}

	public void setPolicy(boolean policy) {
		this.policy = policy;
	}


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroupDomain() {
		return groupDomain;
	}

	public void setGroupDomain(String groupDomain) {
		this.groupDomain = groupDomain;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectDomain() {
		return projectDomain;
	}

	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDomain() {
		return roleDomain;
	}

	public void setRoleDomain(String roleDomain) {
		this.roleDomain = roleDomain;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String[] getProjects() {
		return projects;
	}

	public void setProjects(String[] projects) {
		this.projects = projects;
	}

	public String[] getDomains() {
		return domains;
	}

	public void setDomains(String[] domains) {
		this.domains = domains;
	}
}
