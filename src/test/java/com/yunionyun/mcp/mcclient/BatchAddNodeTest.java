package com.yunionyun.mcp.mcclient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.MonitorNodeManager;

import junit.framework.TestCase;

public class BatchAddNodeTest extends TestCase
{
    public void testApp()
    {
        Client cli = new Client("http://192.168.0.246:35357/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("servicetreeadm", "123@yunion.com", "Default", "system");
            System.out.println(token);
            Session s = cli.newSession("Beijing", null, null, token);
            MonitorNodeManager manager = new MonitorNodeManager();
            
            
            Set<String> sets = new HashSet<String>(Arrays.asList("host01_1.1.1.1", "host02_2.2.2.2"));
            //manager.batchSubmit(s, sets);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
