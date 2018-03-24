package com.yunionyun.mcp.mcclient.managers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ListResult {
	JSONObject[] data;
	int total;
	int limit;
	int offset;
	// String prev;
	// String next;
	
	public ListResult() {
		this.data = null;
		this.total = 0;
		this.limit = 0;
		this.offset = 0;
		// this.prev = null;
		// this.next = null;
	}
	
	public ListResult(JSONObject[] data, int total, int limit, int offset, String prev, String next) {
		this.data = data;
		this.total = total;
		this.limit = limit;
		this.offset = offset;
		// this.prev = prev;
		// this.next = next;
	}
	
	public void parseJSON(JSONObject result, String respKey) {
		JSONArray arr = result.getJSONArray(respKey);
		this.data = new JSONObject[arr.size()];
		for (int i = 0; i < arr.size(); i ++) {
			this.data[i] = arr.getJSONObject(i);
		}
		if (result.containsKey("total")) {
			this.total = result.getIntValue("total");
			if (result.containsKey("limit")) {
				this.limit = result.getIntValue("limit");
			}else {
				this.limit = 0;
			}
			if (result.containsKey("offset")) {
				this.offset = result.getIntValue("offset");
			}else {
				this.offset = 0;
			}
		} else {
			this.total = arr.size();
			this.limit = 0;
			this.offset = 0;
		}
		/* if (result.containsKey("prev")) {
			this.prev = result.getString("prev");
		}
		if (result.containsKey("next")) {
			this.next = result.getString("next");
		}*/
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
