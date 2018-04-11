package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

public class UserManager extends KeystoneManager {
	public UserManager() {
		super("user", "users",
                new String[] {},
                new String[]{"ID", "Name", "Domain_Id",
                        "Enabled", "Email", "Mobile"});
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

}
