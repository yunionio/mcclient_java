package com.yunionyun.mcp.mcclient;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.AlarmMetricHostManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import junit.framework.TestCase;

public class AlarmMetricHostTest extends TestCase
{
    private static Logger logger = LoggerUtils.createLoggerFor(AlarmMetricHostTest.class.getName());
    
    public void testApp()
    {
        Client cli = new Client("http://192.168.0.246:35357/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("servicetreeadm", "123@yunion.com", "Default", "system");
            logger.info(token.toString());
            logger.debug(token.toString());
            Session s = cli.newSession("Beijing", null, null, token);
            AlarmMetricHostManager manager = new AlarmMetricHostManager();
            
            JSONObject query = new JSONObject();
            query.put("metric_name", "disk_inodes_used");
            query.put("template", "1");
            query.put("host_name", "taikangcmdb");
            query.put("host_ip", "10.168.26.213");
            
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
