package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.EndpointsV3Manager;
import junit.framework.TestCase;

/**
 * @author zxc
 * @date 2020/10/28
 */
public class EndpointManagerTest extends TestCase {
	public void test() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("", "", "", "");
			Session s = cli.newSession("", null, null, token, "");
			EndpointsV3Manager manager = new EndpointsV3Manager();
			JSONObject query = new JSONObject();
			query.put("details", true);
			query.put("limit", 0);
			ListResult list = manager.List(s, query);
			if (list != null) {

			}

		} catch (Exception e) {

		}
	}
}
