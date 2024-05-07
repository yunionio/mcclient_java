package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.meter.BillBalanceManager;
import junit.framework.Assert;
import junit.framework.TestCase;

public class BillBalanceTest extends TestCase {
	public void testBatchInsert() {
		String authURL = Env.get("authUrl");
		String domain = Env.get("domain");
		String username = Env.get("username");
		String password = Env.get("password");
		String project = Env.get("project");
		int cacheSize = 0;
		int timeout = 0;
		boolean debug = true;
		boolean insecure = true;

		AuthAgent authAgent =
				new AuthAgent(
						authURL, domain, username, password, project, cacheSize, timeout, debug, insecure);
		authAgent.start_sync_ready();

		Session session = authAgent.getAdminSession(Env.get("region"), null, null);

		try {
			BillBalanceManager manager = new BillBalanceManager();

			JSONObject query = new JSONObject();
			query.put("account_id", "accountList");

			ListResult listResult = manager.List(session, query);

			System.out.println(listResult);

			Assert.assertTrue(listResult.getDataSize() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
