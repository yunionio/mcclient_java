package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.SkuManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/02/28
 */
public class SkuManagerTest extends TestCase {
    private static Logger logger = LoggerUtils.createLoggerFor(SkuManagerTest.class.getName());

    public void testApp() {
        Client cli = new Client("", 500, true, true);
        TokenCredential token = null;
        try {
            token = cli.Authenticate("", "", "Default", "");
            Session s = cli.newSession("", null, null, token, "");
            SkuManager manager = new SkuManager(EndpointType.PublicURL);
            JSONObject query = new JSONObject();
            query.put("t1", null);
            query.put(null, null);
            JSONObject get = manager.Get(s, "instance-specs", query);
            if (get != null){

            }
            logger.debug(query.toString());
        } catch (JSONClientException e) {
            e.printStackTrace();
        } catch (McClientJavaBizException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
