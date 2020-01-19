package com.yunionyun.mcp.mcclient.managers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ComputeManager extends ResourceManager {
	/**
	 *
	 * @param keyword
	 * @param keywordPlural
	 * @param endpointType  EndpointType.InternalURL
	 * @param columns
	 * @param adminColumns
	 */
	public ComputeManager(String keyword, String keywordPlural, EndpointType endpointType, String[] columns, String[] adminColumns) {
		super("compute", endpointType, null, columns, adminColumns, keyword, keywordPlural, null);
	}

}
