package com.yunionyun.mcp.mcclient.managers;

public class ManagerContext {
	ResourceManager manager;
	String id;

	public ManagerContext(ResourceManager mgr, String id) {
		this.manager = mgr;
		this.id = id;
	}

	public String getContextKey() {
		return this.manager.urlKey();
	}

	public String getId() {
		return this.id;
	}
}
