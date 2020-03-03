package com.yunionyun.mcp.mcclient.managers;

import com.yunionyun.mcp.mcclient.EndpointType;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ResTagDetailManager extends MeterManager {
	public ResTagDetailManager() {
		this(EndpointType.InternalURL);
	}

	public ResTagDetailManager(EndpointType endpointType) {
		super(
				"res_tag_detail",
				"res_tag_details",
				endpointType,
				new String[]{"key", "value"},
				new String[]{});
	}
}
