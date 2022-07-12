package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.managers.impl.SkuManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/02/28
 */
public class SkuManagerTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(SkuManagerTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("", "", "Default", "", "");
			Session s = cli.newSession("", null, null, token);
			SkuManager manager = new SkuManager(EndpointType.PublicURL);
			JSONObject query = new JSONObject();
			query.put("public_cloud", false);
			query.put("limit", 0);
			query.put("cpu_core_count", 2);
			query.put("memory_size_mb", 2048);
			query.put("usable", true);
			query.put("project_domain", "default");
			query.put("postpaid_status", "available");
			query.put("cloudregion", "default");
			query.put("city", null);
			query.put("provider", "");
			query.put("zone", null);
			ListResult get = manager.List(s, query);
			if (get != null) {
			}

			logger.debug(query.toString());
		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
