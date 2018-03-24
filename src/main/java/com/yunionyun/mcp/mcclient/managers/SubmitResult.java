package com.yunionyun.mcp.mcclient.managers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SubmitResult {
	private int status;
	private String id;
	private JSONObject data;
	private String errmsg;
	
	private SubmitResult(int status, String id, JSONObject data, String errmsg) {
		this.status = status;
		this.id = id;
		this.data = data;
		this.errmsg = errmsg;
	}
	
	public static SubmitResult[] parseResult(JSONObject obj, String keyword) {
		JSONArray array = obj.getJSONArray(keyword);
		SubmitResult[] results = new SubmitResult[array.size()];
		for (int i = 0; i < array.size(); i++) {
			JSONObject res = array.getJSONObject(i);
			int status = res.getIntValue("status");
			String id = "";
			if (res.containsKey("id")) {
				id = res.getString("id");
			}
			JSONObject dat = null;
			String errmsg = null;
			if (status >= 300) {
				errmsg = res.getString("body");
			} else {
				dat = res.getJSONObject("body");
			}
			results[i] = new SubmitResult(status, id, dat, errmsg);
		}
		return results;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public String getId() {
		return this.id;
	}
	
	public JSONObject getData() {
		return this.data;
	}
	
	public String getErrmsg() {
		return this.errmsg;
	}
	
	public boolean isError() {
		return (this.status >= 300);
	}

}
