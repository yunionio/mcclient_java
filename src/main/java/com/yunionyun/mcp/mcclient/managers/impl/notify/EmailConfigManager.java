package com.yunionyun.mcp.mcclient.managers.impl.notify;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

public class EmailConfigManager extends BaseNotifyManager {
	public EmailConfigManager() {
		this(EndpointType.InternalURL);
	}

	public EmailConfigManager(EndpointType endpointType) {
		super(
				"email_config",
				"email_configs",
				endpointType,
				new String[]{"username", "password", "hostname", "ssl_global", "hostport"},
				new String[]{});
	}
}
