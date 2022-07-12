package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.managers.impl.MonitorNodeManager;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BatchAddNodeTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(BatchAddNodeTest.class.getName());

	public void testApp() {
		Client cli = new Client("", 5000, true, true);
		try {
			TokenCredential token =
					cli.Authenticate("", "", "", "", "");
			logger.info(token.toString());
			logger.debug(token.toString());
			Session s = cli.newSession("", null, null, token);
			MonitorNodeManager manager = new MonitorNodeManager();

			Set<String> sets = new HashSet<String>(Arrays.asList("host01_1.1.1.1", "host02_2.2.2.2"));
			// manager.batchSubmit(s, sets);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
