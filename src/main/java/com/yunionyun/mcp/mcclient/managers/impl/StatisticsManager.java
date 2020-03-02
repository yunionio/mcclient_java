package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class StatisticsManager extends BaseMonitorManager {
	public StatisticsManager() {
		this(EndpointType.InternalURL);
	}

	public StatisticsManager(EndpointType endpointType) {
		super("statistic", "statistics", endpointType, new String[]{"ID"}, new String[]{});
	}
}
