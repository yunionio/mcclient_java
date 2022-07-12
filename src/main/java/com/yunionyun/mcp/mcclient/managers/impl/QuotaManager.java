package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zxc
 * @date 2019/09/26
 */
public class QuotaManager extends ComputeManager {
	public QuotaManager() {
		this(EndpointType.InternalURL);
	}

	public QuotaManager(String keyword, String keywordPlural, EndpointType endpointType) {
		super(keyword, keywordPlural, endpointType, new String[0], new String[0]);
	}

	public QuotaManager(EndpointType endpointType) {
		super("quota", "quotas", endpointType, new String[0], new String[0]);
	}

	public JSONObject get(Session s, Map<String, String> param)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.keywordPlural);
		if (param != null) {
			Iterator var4 = param.entrySet().iterator();

			while (var4.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry) var4.next();
				url.append("/" + (String) entry.getKey() + "/");
				url.append((String) entry.getValue());
			}
		}

		return this._get(s, url.toString(), this.keywordPlural);
	}

	public JSONArray getV2(Session s, Map<String, String> param)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.keywordPlural);
		if (param != null) {
			Iterator var4 = param.entrySet().iterator();

			while (var4.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry) var4.next();
				url.append("/" + (String) entry.getKey() + "/");
				url.append((String) entry.getValue());
			}
		}

		return this._getV2(s, url.toString(), this.keywordPlural);
	}

	public JSONArray addQuota(Session s, String type, String id, JSONObject body, boolean cascade)
			throws McClientJavaBizException, IOException, JSONClientException {
		body.put("action", "add");
		body.put("cascade", cascade);
		return this.quotaSet(s, type, id, body);
	}

	public JSONArray subQuota(Session s, String type, String id, JSONObject body, boolean cascade)
			throws McClientJavaBizException, IOException, JSONClientException {
		body.put("action", "sub");
		body.put("cascade", cascade);
		return this.quotaSet(s, type, id, body);
	}

	public JSONArray replaceQuota(Session s, String type, String id, JSONObject body, boolean cascade)
			throws McClientJavaBizException, IOException, JSONClientException {
		body.put("action", "replace");
		body.put("cascade", cascade);
		return this.quotaSet(s, type, id, body);
	}


	public JSONArray resetQuota(Session s, String type, String id, JSONObject body, boolean cascade)
			throws McClientJavaBizException, IOException, JSONClientException {
		body.put("action", "reset");
		body.put("cascade", cascade);
		return this.quotaSet(s, type, id, body);
	}

	private JSONArray quotaSet(Session s, String type, String id, JSONObject params)
			throws McClientJavaBizException, IOException, JSONClientException {
		if (params == null) {
			return null;
		} else {
			StringBuilder url = new StringBuilder();
			url.append("/");
			url.append(this.keywordPlural);
			url.append("/");
			url.append(type);
			url.append("/");
			url.append(id);
			if ("domains".equals(type) && !params.containsKey("domain")) {
				params.put("domain", id);
			}

			JSONObject body = new JSONObject();
			body.put(this.keywordPlural, params);
			return this._postV2(s, url.toString(), body, this.keywordPlural);
		}
	}
}
