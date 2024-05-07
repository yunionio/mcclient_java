package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.keystone.EndpointsV3Manager;
import junit.framework.TestCase;

/**
 * @author zxc
 * @date 2020/10/28
 */
public class ApigatewayTest extends TestCase {
	public void test() {
		Client cli = new Client(Env.get("authUrl"), 5000, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate(Env.get("username"), 
			Env.get("password"), 
			Env.get("domain"),
			Env.get("project"),
			Env.get("projectDomain"));
			Session s = cli.newSession(Env.get("region"), null, EndpointType.ApigatewayURL, token);
			EndpointsV3Manager manager = new EndpointsV3Manager();
			JSONObject query = new JSONObject();
			query.put("details", true);
			query.put("limit", 0);
			System.out.println("start to query");
			ListResult list = manager.List(s, query);
			System.out.println("end of query");
			if (list != null) {
				System.out.println("results: " + list.getDataSize());
				JSONObject[] endpoints = list.getData();
				for (int i = 0; i < endpoints.length; i++) {
					System.out.println(endpoints[i]);
				}
			}

		} catch (Exception e) {
			System.err.println("Exception" + e);
		}
	}
}
