package com.yunionyun.mcp.mcclient.managers.impl.yunionagent;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class InfoManager extends YunionAgentManager {
	public InfoManager() {
		this(EndpointType.InternalURL);
	}

	public InfoManager(EndpointType endpointType) {
		super("info", "infos", endpointType, new String[]{}, new String[]{});
	}
}
