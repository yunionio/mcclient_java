package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MetadataManager extends ComputeManager {
	public MetadataManager() {
		this(EndpointType.InternalURL);
	}

	public MetadataManager(EndpointType endpointType) {
		super(
				"metadata",
				"metadatas",
				endpointType,
				new String[]{"id", "key", "value"},
				new String[]{});
	}
}
