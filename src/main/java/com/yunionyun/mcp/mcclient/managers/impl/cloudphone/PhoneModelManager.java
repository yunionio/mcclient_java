package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class PhoneModelManager extends CloudphoneManager {

	public PhoneModelManager() {
		this(EndpointType.InternalURL);
	}

	public PhoneModelManager(EndpointType endpointType) {
		super(
				"phone-model",
				"phone-models",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
