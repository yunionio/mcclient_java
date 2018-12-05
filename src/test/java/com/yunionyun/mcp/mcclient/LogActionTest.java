package com.yunionyun.mcp.mcclient;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.LogActionManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import junit.framework.TestCase;

public class LogActionTest extends TestCase
{
    private static Logger logger = LoggerUtils.createLoggerFor(LogActionTest.class.getName());
    
    
    public void testApp()
    {
        Client cli = new Client("http://10.168.222.185:35357/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("yunionapi", "GVQFwVQCjSTMSA8x", "Default", "system");
            logger.info(token.toString());
            logger.debug(token.toString());
           
            Session s = cli.newSession("Yunion", null, null, token, "v2");
            LogActionManager manager = new LogActionManager();
            
            JSONObject params = new JSONObject();
            params.put("obj_type", "servicetree");
            params.put("obj_id", "-");
            params.put("obj_name", "-");
            params.put("success", "True");
            params.put("action", "创建 by TONY");
            params.put("notes", "test by mcclient_java");
            params.put("user_id", "19870507");
            params.put("user", "ningyu");
            
            manager.Create(s, params);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("Some error occured, see details: {}", e);
        }
    }
}
