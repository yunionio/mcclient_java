package com.yunionyun.mcp.mcclient.managers.impl;

import java.util.Map;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseLogActionManager;
import com.yunionyun.mcp.mcclient.managers.ManagerContext;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

public class LogActionManager extends BaseLogActionManager
{
    private static Logger logger = LoggerUtils.createLoggerFor(LogActionManager.class.getName());
    

    public LogActionManager()
    {
        super("action", "actions", new String[] {"obj_type", "obj_id", "obj_name", "success", "action", "notes", "user_id", "user", "tenant_id", "tenant"}, new String[] {});
    }
    
    
    public void record(Session s, JSONObject params)
    {
        doLogAction(s, params);
    }
    
    public void record(Session s, Map<String, Object> map)
    {
        JSONObject params = new JSONObject(map);
        
        doLogAction(s, params);
    }

    private void doLogAction(Session s, JSONObject params) 
    {
        try
        {
            StringBuilder builder = this.getContextPath(new ManagerContext[] {});
            builder.append(this.urlKey());
            
            String url = builder.toString();
            
            super._post(s, url, params, this.keyword);
        }
        catch (Exception e)
        {
            logger.warn("Some error occured during executing doLogAction, see details: {}", e); 
        }
    }
    
}
