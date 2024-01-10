package com.yunionyun.mcp.mcclient.managers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.HttpHeaders;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

import java.io.IOException;
import java.net.HttpURLConnection;

public class BaseManager {

	static final String DEFAULT_API_VERSION = "v1";
	String serviceType;
	EndpointType endpointType;
	String version;
	String[] colums;
	String[] adminColums;
	String[] allColumns;

	public BaseManager(
			String serviceType,
			EndpointType endpointType,
			String version,
			String[] columns,
			String[] adminColumns) {
		this.serviceType = serviceType;
		this.endpointType = endpointType;
		this.version = version;
		this.colums = columns;
		this.adminColums = adminColumns;
		if (this.colums == null) {
			this.colums = new String[0];
		}
		if (this.adminColums == null) {
			this.adminColums = new String[0];
		}
		this.allColumns = new String[this.colums.length + this.adminColums.length];
		for (int i = 0; i < this.colums.length; i++) {
			this.allColumns[i] = this.colums[i];
		}	
		for (int i = 0; i < this.adminColums.length; i++) {
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
			offset += 1;
		}
		url = url.substring(offset);
		if (this.version != null && this.version.length() > 0 && !this.version.equalsIgnoreCase(DEFAULT_API_VERSION)) {
			return "/" + this.version + "/" + url;
		} else {
			return "/" + url;
		}
	}

	protected JSONObject jsonRequest(
			Session s, String method, String url, HttpHeaders headers, JSONObject body)
			throws McClientJavaBizException, IOException, JSONClientException {
		return s.jsonRequest(this.serviceType, this.endpointType, method, this.getUrl(url), headers, body);
	}

	protected HttpURLConnection jsonRawRequest(
			Session s, String method, String url, HttpHeaders headers, JSONObject body)
			throws McClientJavaBizException, IOException, JSONClientException {
		return s.jsonRawRequest(this.serviceType, this.endpointType, method, this.getUrl(url), headers, body);
	}

	public ListResult _list(Session s, String url, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject result = this.jsonRequest(s, "GET", url, null, null);
		ListResult ret = new ListResult();
		ret.parseJSON(result, respKey);
		return ret;
	}

	public JSONArray _listRaw(Session s, String url) throws Exception {
		return s.jsonRequestArray(this.serviceType, this.endpointType, "GET", url, (HttpHeaders) null, (JSONObject) null);
	}

	public JSONObject _get(Session s, String url, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject body = this.jsonRequest(s, "GET", url, null, null);
		if (respKey != null && body != null) {
			return body.getJSONObject(respKey);
		} else {
			return body;
		}
	}

	public HttpURLConnection _head(Session s, String url)
			throws McClientJavaBizException, IOException, JSONClientException {
		return this.jsonRawRequest(s, "HEAD", url, null, null);
	}

	public JSONArray _getV2(Session s, String url, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject body = this.jsonRequest(s, "GET", url, null, null);
		if (respKey != null && body != null) {
			return body.getJSONArray(respKey);
		} else {
			JSONArray arr = new JSONArray();
			arr.add(body);
			return arr;
		}
	}

	public JSONObject _post(Session s, String url, JSONObject body, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
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

	public JSONArray _postV2(Session s, String url, JSONObject body, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject respBody = this.jsonRequest(s, "POST", url, (HttpHeaders) null, body);
		if (respBody != null && respKey != null) {
			return respBody.getJSONArray(respKey);
		} else {
			return null;
		}
	}

	public JSONObject _put(Session s, String url, JSONObject body, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject respBody = this.jsonRequest(s, "PUT", url, null, body);
		if (respKey != null && respBody != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}

	public JSONObject _patch(Session s, String url, JSONObject body, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject respBody = this.jsonRequest(s, "PATCH", url, null, body);
		if (respKey != null && respBody != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}

	public JSONObject _delete(Session s, String url, JSONObject body, String respKey)
			throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject respBody = this.jsonRequest(s, "DELETE", url, null, body);
		if (respKey != null && respBody != null) {
			return respBody.getJSONObject(respKey);
		} else {
			return respBody;
		}
	}

	public EndpointType getEndpontType() {
		return this.endpointType;
	}
}
