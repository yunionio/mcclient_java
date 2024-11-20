package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class PhoneBackupManager extends CloudphoneManager {

	public PhoneBackupManager() {
		this(EndpointType.InternalURL);
	}

	public PhoneBackupManager(EndpointType endpointType) {
		super(
				"phone_backup",
				"phone_backups",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
