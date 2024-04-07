package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class PhoneManager extends CloudphoneManager {

	public PhoneManager() {
		this(EndpointType.InternalURL);
	}

	public PhoneManager(EndpointType endpointType) {
		super(
				"phone",
				"phones",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
