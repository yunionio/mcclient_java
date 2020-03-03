package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.unit.Unit;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import junit.framework.TestCase;
import org.slf4j.Logger;

public class UnitValueTest extends TestCase {
	private static Logger logger = LoggerUtils.createLoggerFor(UnitValueTest.class.getName());

	public void testApp() {
		Unit bps = Unit.parse("bps");
		logger.info(bps.String());
		Unit Mbps = Unit.parse("Mbps");
		logger.info(Mbps.String());
		logger.info(Unit.prettyString(10000000, 2, "bps"));
		logger.info(Unit.prettyString(0.769, 2, "s"));
		logger.info(Unit.prettyString(1024, 2, "KBps"));
		logger.info(Unit.prettyString(1000, 2, "KBps"));
		logger.info(Unit.prettyString(1000, 2, "Kbps"));
	}
}
