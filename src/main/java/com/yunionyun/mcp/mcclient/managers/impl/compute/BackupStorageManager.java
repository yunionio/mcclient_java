package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * 备份存储
 * 
 * @author zxc
 * @date 2020/01/18
 */
public class BackupStorageManager extends ComputeManager {
	public BackupStorageManager() {
		this(EndpointType.InternalURL);
	}

	public BackupStorageManager(EndpointType endpointType) {
		super(
				"backupstorage",
				"backupstorages",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
