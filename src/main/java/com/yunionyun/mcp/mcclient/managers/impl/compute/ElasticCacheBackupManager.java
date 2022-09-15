package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ElasticCacheBackupManager extends ComputeManager {
	public ElasticCacheBackupManager() {
		this(EndpointType.InternalURL);
	}

	public ElasticCacheBackupManager(EndpointType endpointType) {
		super(
				"elasticcachebackup",
				"elasticcachebackups",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
