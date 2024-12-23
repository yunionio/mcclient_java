package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONObject;

public class AuthContext {
	private String source;
	private String ip;

	public AuthContext(String source, String ip) {
		this.source = source;
		this.ip = ip;
	}

	public AuthContext(JSONObject context) {
		this(context.getString("source"), context.getString("ip"));
	}

	public String getSource() {
		return source;
	}

	public String getIp() {
		return ip;
	}
}
