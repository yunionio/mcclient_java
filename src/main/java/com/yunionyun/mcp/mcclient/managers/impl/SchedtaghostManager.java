package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedtaghostManager extends ComputeJointManager {
	public SchedtaghostManager(SchedTagManager master, HostManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public SchedtaghostManager(EndpointType endpointType, SchedTagManager master, HostManager slave) {
		super(
				"schedtaghost",
				"schedtaghosts",
				endpointType,
				new String[]{"Host_ID", "Host", "Schedtag_ID", "Schedtag"},
				new String[]{},
				master,
				slave);
	}
}
