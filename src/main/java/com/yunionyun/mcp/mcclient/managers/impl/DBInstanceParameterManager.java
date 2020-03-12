package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceParameterManager extends ComputeManager {
	public DBInstanceParameterManager() {
		this(EndpointType.InternalURL);
	}

	public DBInstanceParameterManager(EndpointType endpointType) {
		super(
				"dbinstanceparameter",
				"dbinstanceparameters",
				endpointType,
				new String[]{"ID", "Name", "Key", "Value", "Description"},
				new String[]{});
	}
}
