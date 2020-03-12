package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class IdentityUsageManager extends KeystoneManager {
	public IdentityUsageManager() {
		this(EndpointType.AdminURL);
	}

	public IdentityUsageManager(EndpointType endpointType) {
		super("usage", "usages", endpointType, new String[]{}, new String[]{});
	}

	public JSONObject Get(Session s, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.keywordPlural);

		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}

		return this._get(s, url.toString(), this.keyword);
	}
}
