package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.RecipientManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

public class RecipientManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(RecipientManagerTest.class.getName());

	public void testApp() {
		Client cli = new Client("http://192.168.0.246:35357/v3", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("servicetreeadm", "123@yunion.com", "Default", "system");
			logger.info(token.toString());
			logger.debug(token.toString());
			Session s = cli.newSession("Beijing", null, null, token, "");
			RecipientManager manager = new RecipientManager();

			JSONObject query = new JSONObject();
			query.put("node_labels", "corp=1,owt=2,pdl=157,srv=158,env=159");
			query.put("type", "junior");

			ListResult list = manager.List(s, query);

			int dataSize = list.getDataSize();
			for (int i = 0; i < dataSize; i++) {
				System.out.println(list.getDataAt(i));
				logger.debug("---> " + list.getDataAt(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
