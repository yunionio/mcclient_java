package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

public class ContainerManager extends ComputeManager {
	public ContainerManager() {
		this(EndpointType.InternalURL);
	}

	public ContainerManager(EndpointType endpointType) {
		super(
				"container",
				"containers",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Spec",
				},
				new String[]{});
	}
}
