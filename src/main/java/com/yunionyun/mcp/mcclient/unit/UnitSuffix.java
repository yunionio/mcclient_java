package com.yunionyun.mcp.mcclient.unit;

import java.util.ArrayList;
import java.util.List;

class UnitSuffix {
	private String rep;
	
	private static List<UnitSuffix> all;
	
	private UnitSuffix(String rep) {
		this.rep = rep;
		
		all.add(this);
	}
	
	public static final UnitSuffix none;
	public static final UnitSuffix persecond;
	
	static {
		all = new ArrayList<UnitSuffix>();
		
		none = new UnitSuffix("");
		persecond = new UnitSuffix("ps");
	}
	
	protected String String() {
		return this.rep;
	}
	
	protected static UnitSuffix parse(String unitstr) {
		UnitSuffix match = null;
		int matchLen = -1;
		for(UnitSuffix suf: all) {
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
	
	protected int length() {
		return this.rep.length();
	}
}
