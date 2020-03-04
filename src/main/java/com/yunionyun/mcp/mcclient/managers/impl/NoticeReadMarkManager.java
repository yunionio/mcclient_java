package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NoticeReadMarkManager extends YunionAgentManager {
	public NoticeReadMarkManager() {
		this(EndpointType.InternalURL);
	}

	public NoticeReadMarkManager(EndpointType endpointType) {
		super(
				"readmark",
				"readmarks",
				endpointType,
				new String[]{},
				new String[]{"notice_id", "user_id"});
	}
}
