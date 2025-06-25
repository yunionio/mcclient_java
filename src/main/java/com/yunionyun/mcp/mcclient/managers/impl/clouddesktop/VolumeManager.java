package com.yunionyun.mcp.mcclient.managers.impl.clouddesktop;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudDesktopManager;

import java.io.IOException;

public class VolumeManager extends CloudDesktopManager {

	public VolumeManager() {
		this(EndpointType.InternalURL);
	}

	public VolumeManager(EndpointType endpointType) {
		super(
				"volume",
				"volumes",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
