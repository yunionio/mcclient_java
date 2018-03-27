package com.yunionyun.mcp.mcclient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.MonitorMetricManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import junit.framework.TestCase;

public class BatchAddMetricTest extends TestCase
{
    private static Logger logger = LoggerUtils.createLoggerFor(BatchAddMetricTest.class.getName());
    
    
    public void testApp()
    {
        Client cli = new Client("http://192.168.0.246:35357/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("servicetreeadm", "123@yunion.com", "Default", "system");
            logger.info(token.toString());
            logger.debug(token.toString());
            Session s = cli.newSession("Beijing", null, null, token);
            MonitorMetricManager manager = new MonitorMetricManager();
            
            Set<String> sets = new HashSet<String>(Arrays.asList("test_metric01", "test_metric02"));
            //manager.batchSubmit(s, sets);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
