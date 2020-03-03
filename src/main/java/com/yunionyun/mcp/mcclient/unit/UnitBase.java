package com.yunionyun.mcp.mcclient.unit;

import java.util.HashMap;
import java.util.Map;

class UnitBase {
	public static final UnitBase none;
	public static final UnitBase joule;
	public static final UnitBase watt;
	public static final UnitBase bytes;
	public static final UnitBase bits;
	public static final UnitBase hz;
	public static final UnitBase packets;
	public static final UnitBase seconds;
	public static final UnitBase percent;
	public static final UnitBase millionth;
	public static final UnitBase io;
	private static Map<String, UnitBase> all;

	static {
		all = new HashMap<String, UnitBase>();

		none = new UnitBase("", 1000);
		joule = new UnitBase("j", 1000);
		watt = new UnitBase("w", 1000);
		bytes = new UnitBase("B", 1024);
		bits = new UnitBase("b", 1000);
		hz = new UnitBase("hz", 1000);
		packets = new UnitBase("p", 1000);
		seconds = new UnitBase("s", 1000);
		percent = new UnitBase("%", 1000);
		millionth = new UnitBase("%%", 1000);
		io = new UnitBase("io", 1000);
	}

	private String rep;
	private int base;

	private UnitBase(String rep, int base) {
		this.rep = rep;
		this.base = base;
		all.put(rep, this);
	}

	protected static UnitBase parse(String unitstr) {
		if (all.containsKey(unitstr)) {
			return all.get(unitstr);
		} else {
			return new UnitBase(unitstr, 1000);
		}
	}

	protected String String() {
		return this.rep;
	}

	protected int getBase() {
		return this.base;
	}
}
