package com.yunionyun.mcp.mcclient.managers;


import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.HttpHeaders;
import com.yunionyun.mcp.mcclient.Session;

public class BaseManager {
	String serviceType;
	EndpointType endpointType;
	String version;
	String[] colums;
	String[] adminColums;
	String[] allColumns;
 	
	public BaseManager(String serviceType, EndpointType endpointType, String version, String[] columns, String[] adminColumns) {
		this.serviceType = serviceType;
		this.endpointType = endpointType;
		this.version = version;
		this.colums = columns;
		this.adminColums = adminColumns;
		this.allColumns = new String[columns.length + adminColumns.length];
		for (int i = 0; i < columns.length; i ++) {
			this.allColumns[i] = this.colums[i];
		}
		for (int i = 0; i < adminColumns.length; i ++) {
			this.allColumns[this.colums.length + i] = this.adminColums[i];
		}
	}
	
	public String[] getColumns(Session s) {
		if (s.isSystemAdmin()) {
			return this.allColumns;
		} else {
			return this.colums;
		}
	}
	
	public String getUrl(String url) {
		int offset = 0;
		while (url.charAt(offset) == '/') {
			offset +=1;
		}
		url = url.substring(offset);
		if (this.version != null && this.version.length() > 0) {
			return this.version + "/" + url;
		} else {
			return url;
		}
	}
	
	protected JSONObject jsonRequest(Session s, String method, String url, HttpHeaders headers, JSONObject body) throws Exception {
		return s.jsonRequest(this.serviceType, this.endpointType, method, url, headers, body);
	}
	
	public ListResult _list(Session s, String url, String respKey) throws Exception {
		JSONObject result = this.jsonRequest(s, "GET", url, null, null);
		ListResult ret = new ListResult();
		ret.parseJSON(result, respKey);
		return ret;
	}
	
	public JSONObject _get(Session s, String url, String respKey) throws Exception {
		JSONObject body = this.jsonRequest(s, "GET", url, null, null);
		if (respKey != null) {
			return body.getJSONObject(respKey);
		} else {
			return body;
		}
	}
	
	public JSONObject _post(Session s, String url, JSONObject body, String respKey) throws Exception {
		JSONObject respBody = this.jsonRequest(s, "POST", url, null, body);
		
		if (respBody != null) {
		    if (respKey != null) {
		        return respBody.getJSONObject(respKey);
		    } else {
		        return respBody;
		    }
		}
		
		return null;
	}
	
	public JSONObject _put(Session s, String url, JSONObject body, String respKey) throws Exception {
		JSONObject respBody = this.jsonRequest(s, "PUT", url, null, body);
		if (respKey != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}
	
	public JSONObject _patch(Session s, String url, JSONObject body, String respKey) throws Exception {
		JSONObject respBody = this.jsonRequest(s, "PATCH", url, null, body);
		if (respKey != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}
	
	public JSONObject _delete(Session s, String url, JSONObject body, String respKey) throws Exception {
		JSONObject respBody = this.jsonRequest(s, "DELETE", url, null, body);
		if (respKey != null && respBody != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}
}
