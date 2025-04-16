package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class InstantAppManager extends CloudphoneManager {

	public InstantAppManager() {
		this(EndpointType.InternalURL);
	}

	public InstantAppManager(EndpointType endpointType) {
		super(
				"instant_app",
				"instant_apps",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
