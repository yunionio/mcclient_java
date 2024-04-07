package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class PhoneImageManager extends CloudphoneManager {

	public PhoneImageManager() {
		this(EndpointType.InternalURL);
	}

	public PhoneImageManager(EndpointType endpointType) {
		super(
				"phone-image",
				"phone-images",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
