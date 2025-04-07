package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class PhoneAppManager extends CloudphoneManager {

	public PhoneAppManager() {
		this(EndpointType.InternalURL);
	}

	public PhoneAppManager(EndpointType endpointType) {
		super(
				"phone_app",
				"phone_apps",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
