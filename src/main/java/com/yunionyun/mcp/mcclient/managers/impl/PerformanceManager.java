package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

import java.io.IOException;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class PerformanceManager extends BaseMonitorManager {
	public PerformanceManager() {
		this(EndpointType.InternalURL);
	}

	public PerformanceManager(EndpointType endpointType) {
		super(
				"performance",
				"performances",
				endpointType,
				new String[]{
						"cpu_idle", "memory_usage", "disk_ioread", "disk_iowrite", "traffic_in", "traffic_out"
				},
				new String[]{});
	}

	public JSONObject getTop5(Session session, JSONObject params)
			throws JSONClientException, McClientJavaBizException, IOException {
		String node_labels = params.getString("node_labels");
		if (node_labels == null || node_labels.length() == 0) {
			return null;
		}
		StringBuilder url = new StringBuilder();
		url.append("/")
				.append(this.keywordPlural)
				.append("/top5")
				.append("?node_labels=")
				.append(node_labels);
		return _get(session, url.toString(), this.keyword);
	}
}
