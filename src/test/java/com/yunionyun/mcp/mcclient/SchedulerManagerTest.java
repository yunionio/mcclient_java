package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.SchedulerManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/02/06
 */
public class SchedulerManagerTest extends TestCase {
    private static Logger logger = LoggerUtils.createLoggerFor(SchedulerManagerTest.class.getName());

    public void testApp()  {
        Client cli = new Client("", 500, true, true);
        TokenCredential token = null;
        try {
            token = cli.Authenticate("", "", "Default", "");
            Session s = cli.newSession("", null, null, token, "");
            SchedulerManager manager = new SchedulerManager(EndpointType.PublicURL);
            JSONObject jsonObject = manager.doForecast(s, null);
            logger.debug(jsonObject.toString());
        } catch (JSONClientException e) {
            e.printStackTrace();
        } catch (McClientJavaBizException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
