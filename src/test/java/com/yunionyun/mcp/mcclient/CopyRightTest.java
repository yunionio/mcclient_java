package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.CopyrightManage;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

/**
 * @author zxc
 * @date 2021/03/24
 */

public class CopyRightTest extends TestCase {

	private static Logger logger = LoggerUtils.createLoggerFor(CopyRightTest.class.getName());

	public void testCase() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());

			Session s = cli.newSession("", null, EndpointType.PublicURL, token);
			CopyrightManage copyrightManage = new CopyrightManage();
			JSONObject copyright = copyrightManage.Update(s, "copyright", new JSONObject());
			if (copyright != null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Some error occured, see details: {}", e);
		}
	}
}
