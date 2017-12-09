package com.yunionyun.mcp.mcclient.managers;

import org.json.JSONArray;
import org.json.JSONObject;

public class SubmitResult {
	private int status;
	private String id;
	private JSONObject data;
	
	private SubmitResult(int status, String id, JSONObject data) {
		this.status = status;
		this.id = id;
		this.data = data;
	}
	
	public static SubmitResult[] parseResult(JSONObject obj, String keyword) {
		JSONArray array = obj.getJSONArray(keyword);
		SubmitResult[] results = new SubmitResult[array.length()];
		for (int i = 0; i < array.length(); i++) {
			JSONObject res = array.getJSONObject(i);
			int status = res.getInt("status");
			String id = "";
			if (res.has("id")) {
				id = res.getString("id");
			}
			JSONObject dat = res.getJSONObject("data");
			results[i] = new SubmitResult(status, id, dat);
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

}
