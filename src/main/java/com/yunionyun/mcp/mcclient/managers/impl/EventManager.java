package com.yunionyun.mcp.mcclient.managers.impl;



import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;

public class EventManager extends ComputeManager {
	
	public EventManager() {
		super("event", "events",
	               new String[] {"id",
	            		   "ops_time", "obj_id", "obj_type", "obj_name",
	            		   "action", "notes",
	            		   "owner_tenant_id"},
	             new String[] {});
	}
	
	@Override
	public ListResult List(Session s, JSONObject query, ManagerContext[] ctx) throws McClientJavaBizException, IOException, JSONClientException  {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.keywordPlural);
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._list(s, url.toString(), this.keywordPlural);
	}
}
