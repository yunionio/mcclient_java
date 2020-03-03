package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONObject;

public abstract class BaseResource {
	private String id;
	private String name;

	public void parseJSON(JSONObject obj) {
		id = obj.getString("id");
		name = obj.getString("name");
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
}
