package com.yunionyun.mcp.mcclient.managers.impl;

import java.io.IOException;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;

public class MonitorNodeManager extends BaseMonitorManager {

	public MonitorNodeManager() {
		super("node", "nodes",
		        new String[] {"ID", "name", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
		        new String[] {});
	}
	
    public void batchSubmit(Session s, Set<String> sets) throws McClientJavaBizException, IOException, JSONClientException 
    {
        JSONArray nodes = new JSONArray();
        
        for (String str : sets)
        {
            String[] splited = str.split("_");
            
            if (splited != null && splited.length == 2)
            {
                JSONObject node = new JSONObject();
                node.put("name", splited[0]);
                node.put("ip", splited[1]);
                nodes.add(node);
            }
        }
        
        JSONObject params = new JSONObject();
        params.put("nodes", nodes);
        
        StringBuilder url = this.getContextPath(new ManagerContext[] {});
        url.append(this.urlKey());
        
        this._post(s, url.toString(), params, null);
    }
}