package com.yunionyun.mcp.mcclient.keystone;

import org.json.JSONObject;

public class User extends BaseResource {
	private Domain domain;
	
	public void parseJSON(JSONObject obj) {
		super.parseJSON(obj);
		domain = new Domain();
		domain.parseJSON(obj.getJSONObject("domain"));
	}
	
	public Domain getDomain() {
		return this.domain;
	}
}
