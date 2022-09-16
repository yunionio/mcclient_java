package com.yunionyun.mcp.mcclient.managers.impl.yunionagent;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NoticeManager extends YunionAgentManager {
	public NoticeManager() {
		this(EndpointType.InternalURL);
	}

	public NoticeManager(EndpointType endpointType) {
		super(
				"notice",
				"notices",
				endpointType,
				new String[]{"id", "created_at", "updated_at", "author_id", "author", "title", "content"},
				new String[]{});
	}
}
