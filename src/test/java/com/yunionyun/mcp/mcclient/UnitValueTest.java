package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.unit.Unit;

import junit.framework.TestCase;

public class UnitValueTest extends TestCase {
	public void testApp() {
		Unit bps = Unit.parse("bps");
		System.out.println(bps.String());
		Unit Mbps = Unit.parse("Mbps");
		System.out.println(Mbps.String());
		System.out.println(Unit.prettyString(10000000, 2, "bps"));
		System.out.println(Unit.prettyString(0.769, 2, "s"));
		System.out.println(Unit.prettyString(1024, 2, "KBps"));
	}
}
