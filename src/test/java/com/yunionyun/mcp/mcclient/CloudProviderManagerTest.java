package com.yunionyun.mcp.mcclient;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.CloudProviderManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import junit.framework.TestCase;

public class CloudProviderManagerTest extends TestCase
{
    private static Logger logger = LoggerUtils.createLoggerFor(CloudProviderManagerTest.class.getName());
    
    
    public void testApp()
    {
        Client cli = new Client("http://192.168.0.246:5000/v3", 5000, true, true);
        try
        {
            TokenCredential token = cli.Authenticate("sysadmin", "ieju4an@ahJe18Q2", "Default", "system");
            logger.info(token.toString());
            logger.debug(token.toString());
            Session s = cli.newSession("YunionHQ", null, null, token, "v2");
            CloudProviderManager manager = new CloudProviderManager();
            
            JSONObject query = new JSONObject();
            query.put("filter", "provider.equals(vmware)");
            
            ListResult listAll = manager.List(s, query);
            for (int i = 0; i < listAll.getDataSize(); i++)
            {
                JSONObject object = listAll.getDataAt(i);
                for (String key : object.keySet())
                {
                    logger.info("{} : {}", key, object.get(key));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
