package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.BillBalanceManager;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BillBalanceTest extends TestCase
{
    public void testBatchInsert()
    {
        String authURL = "https://192.168.222.171:5000/v3";
        String domain = "Default";
        String username = "sysadmin";
        String password = "ixtPb1Z3_crqS8YG";
        String project = "system";
        int cacheSize = 0;
        int timeout = 0;
        boolean debug = true;
        boolean insecure = true;
        
        AuthAgent authAgent = new AuthAgent(authURL, domain, username, password, project, cacheSize, timeout, debug, insecure);
        authAgent.start_sync_ready();
        
        Session session = authAgent.getAdminSession("YunionHQ", null, null, "");
        
        try
        {
            BillBalanceManager manager = new BillBalanceManager();
            
            JSONObject query = new JSONObject();
            query.put("account_id", "accountList");
            
            ListResult listResult = manager.List(session, query);
            
            System.out.println(listResult);

            Assert.assertTrue(listResult.getDataSize() > 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
