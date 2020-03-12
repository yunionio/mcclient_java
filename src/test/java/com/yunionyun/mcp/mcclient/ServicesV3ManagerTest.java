package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.ServicesV3Manager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/03/03
 */
public class ServicesV3ManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(ServicesV3ManagerTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("", "", "", "");
			Session s = cli.newSession("", null, null, token, "");
			ServicesV3Manager manager = new ServicesV3Manager();
			JSONObject rtn = manager.GetSpecific(s, "common", "config", null);
			logger.debug(rtn.toString());
			if (rtn != null) {
				if (rtn == null
						|| rtn.getJSONObject("config") == null
						|| rtn.getJSONObject("config").getJSONObject("default") == null) {
					System.out.println("false");
				}
				if (rtn.getJSONObject("config")
						.getJSONObject("default")
						.getBoolean("non_default_domain_projects")
						== null) {
					System.out.println("false");
				}
				System.out.println(
						rtn.getJSONObject("config")
								.getJSONObject("default")
								.getBoolean("non_default_domain_projects"));
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
