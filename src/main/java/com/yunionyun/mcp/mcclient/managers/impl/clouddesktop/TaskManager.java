package com.yunionyun.mcp.mcclient.managers.impl.clouddesktop;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.CloudDesktopManager;

import java.io.IOException;

public class TaskManager extends CloudDesktopManager {

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
