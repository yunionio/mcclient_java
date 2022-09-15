package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.compute.SkuManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/03/04
 */
public class NetworkManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(NetworkManagerTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("", "", "", "", "");
			Session s = cli.newSession("", null, null, token);
//			NetworkManager manager = new NetworkManager(EndpointType.PublicURL);
			SkuManager manager = new SkuManager(EndpointType.PublicURL);
			JSONObject query = new JSONObject();
//			query.put("filter.0", "server-type.notin(ipmi,pex)");
//			query.put("usable", null);
//			query.put("cloudregion", "06c51007-0696-4bfd-8a2e-563cb7821f7e");
//			query.put("project_domain", "default");
//			ListResult list = manager.List(s, query);
			ListResult list = manager.List(s, query);
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
