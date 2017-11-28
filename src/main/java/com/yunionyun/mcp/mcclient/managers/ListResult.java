package com.yunionyun.mcp.mcclient.managers;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListResult {
	JSONObject[] data;
	int total;
	int limit;
	int offset;
	String prev;
	String next;
	
	public ListResult() {
		this.data = null;
		this.total = 0;
		this.limit = 0;
		this.offset = 0;
		this.prev = null;
		this.next = null;
	}
	
	public ListResult(JSONObject[] data, int total, int limit, int offset, String prev, String next) {
		this.data = data;
		this.total = total;
		this.limit = limit;
		this.offset = offset;
		this.prev = prev;
		this.next = next;
	}
	
	public void parseJSON(JSONObject result, String respKey) {
		JSONArray arr = result.getJSONArray(respKey);
		this.data = new JSONObject[arr.length()];
		for (int i = 0; i < arr.length(); i ++) {
			this.data[i] = arr.getJSONObject(i);
		}
		if (result.has("total")) {
			this.total = result.getInt("total");
			if (result.has("limit")) {
				this.limit = result.getInt("limit");
			}else {
				this.limit = 0;
			}
			if (result.has("offset")) {
				this.offset = result.getInt("offset");
			}else {
				this.offset = 0;
			}
		} else {
			this.total = arr.length();
			this.limit = 0;
			this.offset = 0;
		}
		if (result.has("prev")) {
			this.prev = result.getString("prev");
		}
		if (result.has("next")) {
			this.next = result.getString("next");
		}		
	}
	
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("total: " +  total + "\n");
		buf.append("limit: " + limit + "\n");
		buf.append("offset: " + offset + "\n");
		for (int i = 0; i < this.data.length; i ++) {
			buf.append(this.data[i].toString());
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public int getPage() {
		if (this.limit > 0) {
			return (this.offset / this.limit) + 1;
		}else {
			return 1;
		}
	}
	
	public int getPages() {
		if (this.limit > 0) {
			return (this.total / this.limit) + 1;
		} else {
			return 1;
		}
	}
	
	public JSONObject getDataAt(int idx) {
		if (this.data != null && this.data.length > 0 && idx >= 0 && idx < data.length) {
			return this.data[idx];
		}else {
			return null;
		}
	}
	
	public int getDataSize() {
		return this.data.length;
	}
}
