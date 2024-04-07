package com.yunionyun.mcp.mcclient.managers.impl.cloudphone;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudphoneManager;

import java.io.IOException;

public class TaskManager extends CloudphoneManager {

	public TaskManager() {
		this(EndpointType.InternalURL);
	}

	public TaskManager(EndpointType endpointType) {
		super(
				"task",
				"tasks",
				endpointType,
				new String[]{
				},
				new String[]{
                });
	}

}
