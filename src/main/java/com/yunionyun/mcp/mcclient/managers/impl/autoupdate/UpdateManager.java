package com.yunionyun.mcp.mcclient.managers.impl.autoupdate;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseAutoUpdateManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class UpdateManager extends BaseAutoUpdateManager {
	public UpdateManager() {
		this(EndpointType.InternalURL);
	}

	public UpdateManager(EndpointType endpointType) {
		super(
				"update",
				"updates",
				endpointType,
				new String[]{"localVersion", "remoteVersion", "status", "updateAvailable"},
				new String[]{});
	}
}
