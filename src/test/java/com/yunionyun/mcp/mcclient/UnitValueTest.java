package com.yunionyun.mcp.mcclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yunionyun.mcp.mcclient.unit.Unit;

import junit.framework.TestCase;

public class UnitValueTest extends TestCase {
    private static Logger logger = LoggerFactory.getLogger(UnitValueTest.class);
    
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
