package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.GlanceManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class GuestImageManager extends GlanceManager {
	public GuestImageManager() {
		this(EndpointType.InternalURL);
	}

	public GuestImageManager(EndpointType endpointType) {
		super(
				"guestimage",
				"guestimages",
				endpointType,
				new String[]{"ID", "Name", "Status", "Size"},
				new String[]{});
	}
}
