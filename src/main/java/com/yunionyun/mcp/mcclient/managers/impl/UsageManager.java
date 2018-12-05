package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class UsageManager extends ComputeManager
{
    public UsageManager()
    {
    	super("usage", "usages", new String[] { "Field", "Value" }, new String[] {});
    }
    
    
    public JSONObject Get(Session s, JSONObject query) throws Exception
    {
        StringBuilder url = new StringBuilder();
        url.append("/");
        url.append(this.keywordPlural);
        
        if (query != null)
        {
            String queryStr = Utils.JSONObject2QueryString(query);
            if (queryStr.length() > 0)
            {
                url.append("?");
                url.append(queryStr);
            }
        }
        
        return this._get(s, url.toString(), this.keyword);
    }
}
