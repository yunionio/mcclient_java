package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.compute.LogActionManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

public class LogActionTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(LogActionTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("region0", null, EndpointType.PublicURL, token);
//			LogManager manager = new LogManager();
			LogActionManager manager = new LogActionManager();
			JSONObject params = new JSONObject();
			params.put("obj_type", "eip");
			params.put("obj_id", "d1f6ebdf-4bac-4b22-853d-8928c970af7d");
			params.put("action", "detach");
			params.put("scope", "system");
			params.put("limit", "0");
			params.put("filter", "action.in(eip_detach)");
			ListResult list = manager.List(s, params);
			if (list != null) {

			}
//			JSONObject params = new JSONObject();
//			params.put("obj_type", "servicetree");
//			params.put("obj_id", "-");
//			params.put("obj_name", "-");
//			params.put("success", "True");
//			params.put("action", "创建 by TONY");
//			params.put("notes", "test by mcclient_java");
//			params.put("user_id", "19870507");
//			params.put("user", "xxx");

			manager.Create(s, params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}
}
