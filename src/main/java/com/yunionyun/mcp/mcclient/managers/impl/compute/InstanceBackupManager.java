package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * 主机备份
 * 
 * @author zxc
 * @date 2020/01/18
 */
public class InstanceBackupManager extends ComputeManager {
	public InstanceBackupManager() {
		this(EndpointType.InternalURL);
	}

	public InstanceBackupManager(EndpointType endpointType) {
		super(
				"instancebackup",
				"instancebackups",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
