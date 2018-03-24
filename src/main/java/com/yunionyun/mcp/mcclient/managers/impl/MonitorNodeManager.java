package com.yunionyun.mcp.mcclient.managers.impl;

import java.util.Set;

import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

public class MonitorNodeManager extends BaseMonitorManager {

	public MonitorNodeManager() {
		super("node", "nodes",
		        new String[] {"ID", "name", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
		        new String[] {});
	}
	
	public void batchSubmit(Session s, Set<String> sets) throws Exception {
		JSONObject params = new JSONObject();
		this.Create(s, params);
	}
}