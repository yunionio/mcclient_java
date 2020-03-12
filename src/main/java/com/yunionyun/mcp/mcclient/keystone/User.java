package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONObject;

public class User extends BaseResource {
	private Domain domain;

	@Override
	public void parseJSON(JSONObject obj) {
		super.parseJSON(obj);
		domain = new Domain();
		domain.parseJSON(obj.getJSONObject("domain"));
	}

	public Domain getDomain() {
		return this.domain;
	}
}
