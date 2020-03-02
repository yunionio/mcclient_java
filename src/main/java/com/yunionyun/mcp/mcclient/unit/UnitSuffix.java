package com.yunionyun.mcp.mcclient.unit;

import java.util.ArrayList;
import java.util.List;

class UnitSuffix {
	public static final UnitSuffix none;
	public static final UnitSuffix persecond;
	private static List<UnitSuffix> all;

	static {
		all = new ArrayList<UnitSuffix>();

		none = new UnitSuffix("");
		persecond = new UnitSuffix("ps");
	}

	private String rep;

	private UnitSuffix(String rep) {
		this.rep = rep;

		all.add(this);
	}

	protected static UnitSuffix parse(String unitstr) {
		UnitSuffix match = null;
		int matchLen = -1;
		for (UnitSuffix suf : all) {
			if (suf.rep != null && unitstr.endsWith(suf.rep) && matchLen < suf.rep.length()) {
				match = suf;
				matchLen = suf.rep.length();
			}
		}
		if (match == null) {
			match = none;
		}
		return match;
	}

	protected String String() {
		return this.rep;
	}

	protected int length() {
		return this.rep.length();
	}
}
