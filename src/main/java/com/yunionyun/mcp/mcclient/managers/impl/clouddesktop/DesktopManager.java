package com.yunionyun.mcp.mcclient.managers.impl.clouddesktop;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudDesktopManager;

public class DesktopManager extends CloudDesktopManager {
	public DesktopManager() {
		this(EndpointType.InternalURL);
	}

	public DesktopManager(EndpointType endpointType) {
		super(
				"desktop",
				"desktops",
				endpointType,
				new String[]{
				},
				new String[]{
				});
	}
}
