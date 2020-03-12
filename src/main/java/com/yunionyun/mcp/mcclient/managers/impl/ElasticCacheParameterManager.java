package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ElasticCacheParameterManager extends ComputeManager {
	public ElasticCacheParameterManager() {
		this(EndpointType.InternalURL);
	}

	public ElasticCacheParameterManager(EndpointType endpointType) {
		super(
				"elasticcacheparameter",
				"elasticcacheparameters",
				endpointType,
				new String[]{},
				new String[]{});
	}
}
