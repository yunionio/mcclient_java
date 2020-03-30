package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.UserManager;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/03/27
 */
public class UserMangerTest extends TestCase {
	public void testApp() {
		Client cli = new Client("x", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("x", "x", "", "system");
			Session s = cli.newSession("x", null, null, token, "");
			UserManager userManager = new UserManager();
			JSONObject ob = new JSONObject();
			ob.put("x", "x");
			ListResult list = userManager.List(s, null);
			if (list != null) {

			}
		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
