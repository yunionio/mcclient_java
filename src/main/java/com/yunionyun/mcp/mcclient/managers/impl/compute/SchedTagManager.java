package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class SchedTagManager extends ComputeManager {
	public SchedTagManager() {
		this(EndpointType.InternalURL);
	}

	public SchedTagManager(EndpointType endpointType) {
		super(
				"schedtag",
				"schedtags",
				endpointType,
				new String[]{"ID", "Name", "Default_strategy"},
				new String[]{});
	}
  /*Schedtags = NewComputeManager("schedtag", "schedtags",
     []string{"ID", "Name", "Default_strategy"},
  []string{})*/
}
