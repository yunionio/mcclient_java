package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * 磁盘备份
 * 
 * @author zxc
 * @date 2020/01/18
 */
public class DiskBackupManager extends ComputeManager {
	public DiskBackupManager() {
		this(EndpointType.InternalURL);
	}

	public DiskBackupManager(EndpointType endpointType) {
		super(
				"diskbackup",
				"diskbackups",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
