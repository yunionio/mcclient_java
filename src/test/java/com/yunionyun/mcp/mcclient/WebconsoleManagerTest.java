package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.webconsole.WebConsoleManager;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zxc
 * @date 2020/03/27
 */
public class WebconsoleManagerTest extends TestCase {
	public void testApp() {
		Client cli = new Client(Env.get("authUrl"), 500, true, true);
		try {
			TokenCredential token = cli.Authenticate(Env.get("username"), 
			Env.get("password"), 
			Env.get("domain"),
			Env.get("project"),
			Env.get("projectDomain"));
			Session s = cli.newSession(Env.get("region"), "", EndpointType.PublicURL, token);

			WebConsoleManager webconsole = new WebConsoleManager();

			JSONObject result = webconsole.DoSshConnect(s, "servername", "", 0, "", "");
			System.out.println(result);

			result = webconsole.DoRdpConnect(s, "ed73df6af7b", "", 0, "Administrator", "passwd0");
			System.out.println(result);

		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
