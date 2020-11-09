package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.InfoManager;
import com.yunionyun.mcp.mcclient.managers.impl.NotifyManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

/**
 * @author zxc
 * @date 2020/11/05
 */
public class NotifyManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(NotifyManagerTest.class.getName());

	public void test() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("region0", null, EndpointType.PublicURL, token, "v1");
//			LogManager manager = new LogManager();
			NotifyManager notify = new NotifyManager();
			JSONObject params = new JSONObject();
			params.put("topic", "test");
			params.put("contact_type", "webconsole");
			params.put("priority", "normal");
			params.put("message", "test");
			params.put("receivers", new String[]{"e68ec85c57084a4c859b967c092ec4b4"});
			params.put("uid", new String[]{"e68ec85c57084a4c859b967c092ec4b4"});


			JSONObject created = notify.Create(s, params);
			if (created != null) {

			}
			InfoManager infoManager = new InfoManager();
			JSONObject jsonObject = infoManager.GetById(s, "info", new JSONObject());
			if (jsonObject != null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}
}
