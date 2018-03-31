package com.yunionyun.mcp.mcclient.managers.impl;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;

public class MonitorMetricManager extends BaseMonitorManager
{
    
    public MonitorMetricManager()
    {
        super("metric", "metrics", new String[] { "id", "name", "description", "unit", "common_unit", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete",
                "is_deleted", "project_id", "remark" }, new String[] {});
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
    
    public ListResult listAll(Session s) throws Exception
    {
        ListResult tmpList = this.List(s, null);
        int dataSize = tmpList.getDataSize();
        
        if (tmpList.getTotal() <= dataSize)
        {
            return tmpList;
        }
        
        JSONObject query = new JSONObject();
        query.put("offset", 0);
        query.put("limit", tmpList.getTotal());
        
        return this.List(s, query);
    }
}
