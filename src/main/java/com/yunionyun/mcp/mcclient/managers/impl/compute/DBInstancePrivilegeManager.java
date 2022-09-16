package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstancePrivilegeManager extends ComputeManager {
	public DBInstancePrivilegeManager() {
		this(EndpointType.InternalURL);
	}

	public DBInstancePrivilegeManager(EndpointType endpointType) {
		super(
				"dbinstanceprivilege",
				"dbinstanceprivileges",
				endpointType,
				new String[]{
						"DBInstanceaccount_id",
						"DBInstancedatabase_id",
						"DBInstanceaccount",
						"DBInstancedatabase",
						"Privilege"
				},
				new String[]{});
	}
}
