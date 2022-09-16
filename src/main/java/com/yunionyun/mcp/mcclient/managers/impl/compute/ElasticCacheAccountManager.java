package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ElasticCacheAccountManager extends ComputeManager {
	public ElasticCacheAccountManager() {
		this(EndpointType.InternalURL);
	}

	public ElasticCacheAccountManager(EndpointType endpointType) {
		super(
				"elasticcacheaccount",
				"elasticcacheaccounts",
				endpointType,
				new String[]{},
				new String[]{});
	}

	public JSONObject getLoginInfo(Session session, String id, JSONObject params)
			throws JSONClientException, McClientJavaBizException, IOException {
		return GetSpecific(session, id, "login-info", params);
	}
}
