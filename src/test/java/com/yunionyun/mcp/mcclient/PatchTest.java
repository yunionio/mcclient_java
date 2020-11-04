package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.ProjectManager;
import junit.framework.TestCase;

public class PatchTest extends TestCase {
	public void testApp() {
		Client cli = new Client("", 1000, true, true);
		try {
			TokenCredential token = cli.Authenticate("", "", "", "");
			Session s = cli.newSession("", null, null, token, "");
			ProjectManager projman = new ProjectManager();
			JSONObject results = projman.GetByName(s, "system", null);
			String id = results.getString("id");
			JSONObject params = new JSONObject();
			params.put("URL", "http://wwww.sina.com.cn");
			projman.Patch(s, id, params);
			results = projman.GetByName(s, "system", null);
			for (String key : results.keySet()) {
				System.out.println(key + ": " + results.getString(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
