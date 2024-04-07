package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class VolumeManager extends CloudphoneManager {

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
