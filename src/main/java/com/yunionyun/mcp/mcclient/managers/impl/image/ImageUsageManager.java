package com.yunionyun.mcp.mcclient.managers.impl.image;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.GlanceManager;

public class ImageUsageManager extends GlanceManager {
	public ImageUsageManager() {
		this(EndpointType.InternalURL);
	}

	public ImageUsageManager(EndpointType endpointType) {
		super("usage", "usages", endpointType, new String[]{"Field", "Value"}, new String[]{});
	}
}
