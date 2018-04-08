package com.yunionyun.mcp.mcclient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.HostAlarmRecipientManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import junit.framework.TestCase;

public class HostAlarmRecipientTest extends TestCase
{
    private static Logger logger = LoggerUtils.createLoggerFor(HostAlarmRecipientTest.class.getName());
    
    public void testApp()
    {
        Client cli = new Client("http://192.168.0.246:35357/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("servicetreeadm", "123@yunion.com", "Default", "system");
            logger.info(token.toString());
            logger.debug(token.toString());
            Session s = cli.newSession("Beijing", null, null, token);
            HostAlarmRecipientManager manager = new HostAlarmRecipientManager();
            
            JSONObject query = new JSONObject();
            query.put("host_name", "git");
            query.put("metric_name", "cpu.usage_user");
            query.put("template", "2,3");
            
            ListResult list = manager.List(s, query);
            
            int dataSize = list.getDataSize();
            for (int i = 0; i < dataSize; i++)
            {
                logger.debug( "---> " + list.getDataAt(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
