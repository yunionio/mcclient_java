package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DynamicschedtagManager extends ComputeManager {
	public DynamicschedtagManager() {
		this(EndpointType.InternalURL);
	}

	public DynamicschedtagManager(EndpointType endpointType) {
		super(
				"dynamicschedtag",
				"dynamicschedtags",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Description",
						"Condition",
						"Schedtag",
						"Schedtag_Id",
						"Resource_Type",
						"Enabled"
				},
				new String[]{});
	}
}
