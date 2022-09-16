package com.yunionyun.mcp.mcclient.managers.impl.yunionagent;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class CopyrightManage extends YunionAgentManager {
	public CopyrightManage() {
		this(EndpointType.InternalURL);
	}

	public CopyrightManage(EndpointType endpointType) {
		super("info", "infos", endpointType, new String[]{"copyright", "email"}, new String[]{});
	}
}
