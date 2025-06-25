package com.yunionyun.mcp.mcclient.managers.impl.clouddesktop;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudDesktopManager;

public class DesktopModelManager extends CloudDesktopManager {

	public DesktopModelManager() { this(EndpointType.InternalURL); }

	public DesktopModelManager(EndpointType endpointType) {
		super(
				"desktop_model",
				"desktop_models",
				endpointType,
				new String[]{
				},
				new String[]{
				});
	}
}
