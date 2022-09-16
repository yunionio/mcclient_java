package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceDatabaseManager extends ComputeManager {
	public DBInstanceDatabaseManager() {
		this(EndpointType.InternalURL);
	}

	public DBInstanceDatabaseManager(EndpointType endpointType) {
		super(
				"dbinstancedatabase",
				"dbinstancedatabases",
				endpointType,
				new String[]{"ID", "Name", "Character_Set", "DBInstance_id", "DBInstance", "Status"},
				new String[]{});
	}
}
