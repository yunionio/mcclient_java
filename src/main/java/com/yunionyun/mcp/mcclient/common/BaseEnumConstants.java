package com.yunionyun.mcp.mcclient.common;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseEnumConstants {
	private String rep;
	private static Map<String, BaseEnumConstants> constantsMap;
	
	static {
		constantsMap = new HashMap<String, BaseEnumConstants>();
	}
	
	public BaseEnumConstants(String rep) {
		this.rep = rep;
		constantsMap.put(rep, this);
	}
	
	@Override
	public String toString() {
		return this.rep;
	}
	
	public static BaseEnumConstants string2Const(String str) {
		if (constantsMap.containsKey(str)) {
			return constantsMap.get(str);
		}else {
			return null;
		}
	}
}
