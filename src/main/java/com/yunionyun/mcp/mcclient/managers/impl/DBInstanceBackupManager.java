package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceBackupManager extends ComputeManager {
	public DBInstanceBackupManager() {
		this(EndpointType.InternalURL);
	}

	public DBInstanceBackupManager(EndpointType endpointType) {
		super(
				"dbinstancebackup",
				"dbinstancebackups",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Start_Time",
						"End_Time",
						"Status",
						"Backup_Type",
						"DBNames",
						"Backup_Size_Mb",
						"DBInstance",
						"Engine",
						"EngineVersion"
				},
				new String[]{});
	}
}
