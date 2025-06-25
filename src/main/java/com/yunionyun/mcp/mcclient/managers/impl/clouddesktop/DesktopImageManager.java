package com.yunionyun.mcp.mcclient.managers.impl.clouddesktop;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudDesktopManager;

public class DesktopImageManager extends CloudDesktopManager {

	public DesktopImageManager() {
		this(EndpointType.InternalURL);
	}

	public DesktopImageManager(EndpointType endpointType) {
		super(
				"desktop_image",
				"desktop_images",
				endpointType,
				new String[]{
				},
				new String[]{
				});
	}
}
