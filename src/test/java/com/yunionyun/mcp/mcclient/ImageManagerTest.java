package com.yunionyun.mcp.mcclient;

import java.io.IOException;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.image.ImageManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;

public class ImageManagerTest extends TestCase {
    private static Logger logger = LoggerUtils.createLoggerFor(ImageManagerTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 500, true, true);
		TokenCredential token = null;
		try {
			token = cli.Authenticate("", "", "Default", "", "");
			Session s = cli.newSession("", null, null, token);
			ImageManager manager = new ImageManager(EndpointType.PublicURL);
			JSONObject params = new JSONObject();
			String id = new String("5b3fa029-74cd-4c5d-88d8-034ce4b4e9d9");
			params.put("name", "name-update");
			JSONObject image = manager.Update(s, id, params);
			if (image != null) {
				logger.debug(image.toString());
			}
			logger.debug(params.toString());
		} catch (JSONClientException e) {
			e.printStackTrace();
		} catch (McClientJavaBizException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
