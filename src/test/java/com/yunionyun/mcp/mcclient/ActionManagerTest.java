package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.meter.PriceInfoManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

/**
 * @author zxc
 * @date 2021/04/26
 */
public class ActionManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(CopyRightTest.class.getName());

	public void test() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("", null, EndpointType.PublicURL, token);

			PriceInfoManager priceInfoManager = new PriceInfoManager();
			JSONObject query = new JSONObject();
			query.put("scope", "system");
			query.put("quantity", "1");
			query.put("brand", "OneCloud");
			query.put("spec", "cpu=2core;mem=2 GB;disk=30GB,model=rotate::rbd-1;disk=0GB,model=undefined::");
			ListResult list = priceInfoManager.List(s, query);
			if (list != null) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}

}
