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
}
