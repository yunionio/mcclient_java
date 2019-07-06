package com.yunionyun.mcp.mcclient.managers.impl;

import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.GlanceManager;

public class ImageQuotaManager extends GlanceManager
{
    public ImageQuotaManager()
    {
        super("quota", "quotas", new String[] {}, new String[] {});
    }
    
    
    public JSONObject get(Session s, Map<String, String> param) throws McClientJavaBizException, IOException, JSONClientException
    {
        StringBuilder url = new StringBuilder();
        url.append("/");
        url.append(this.keywordPlural);
        
        if (param != null)
        {
            for (Map.Entry<String, String> entry : param.entrySet())
            {
                url.append("/" + entry.getKey() + "/");
                url.append(entry.getValue());
            }
        }
        
        return this._get(s, url.toString(), this.keywordPlural);
    }
    
    public JSONObject addQuota(Session s, String type, String id, JSONObject body, boolean cascade) throws McClientJavaBizException, IOException, JSONClientException
    {
        body.put("action", "add");
        body.put("cascade", cascade);
        return quotaSet(s, type, id, body);
    }
    
    public JSONObject resetQuota(Session s, String type, String id, JSONObject body, boolean cascade) throws McClientJavaBizException, IOException, JSONClientException
    {
        body.put("action", "reset");
        body.put("cascade", cascade);
        return quotaSet(s, type, id, body);
    }
    
    private JSONObject quotaSet(Session s, String type, String id, JSONObject params) throws McClientJavaBizException, IOException, JSONClientException
    {
        if (params == null)
        {
            return null;
        }
        
        StringBuilder url = new StringBuilder();
        url.append("/");
        url.append(this.keywordPlural);
        url.append("/");
        url.append(type);
        url.append("/");
        url.append(id);
        
        if ("domains".equals(type) && !params.containsKey("domain"))
        {
            params.put("domain", id);
        }
        
        JSONObject body = new JSONObject();
        body.put(keywordPlural, params);
        
        return this._post(s, url.toString(), body, this.keywordPlural);
    }
}
