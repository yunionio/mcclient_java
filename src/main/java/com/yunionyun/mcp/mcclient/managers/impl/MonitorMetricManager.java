package com.yunionyun.mcp.mcclient.managers.impl;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;

public class MonitorMetricManager extends BaseMonitorManager {

	public MonitorMetricManager() {
		super("metric", "metrics",
		        new String[] {"id", "name", "description", "unit", "common_unit", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
		        new String[] {});
	}
	
	public void batchSubmit(Session s, Set<String> sets) throws Exception 
	{
	    JSONArray metrics = new JSONArray();
	    for (String name : sets)
        {
	        JSONObject node = new JSONObject();
	        node.put("name", name);
	        metrics.add(node);
        }
	    
	    JSONObject params = new JSONObject();
		params.put("metrics", metrics);
		
		StringBuilder url = this.getContextPath(new ManagerContext[] {});
        url.append(this.urlKey());
        
        this._post(s, url.toString(), params, null);
	}
}
