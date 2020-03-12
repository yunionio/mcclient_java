package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseVNCProxyManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class VNCProxyManager extends BaseVNCProxyManager {
	public VNCProxyManager() {
		this(EndpointType.InternalURL);
	}

	public VNCProxyManager(EndpointType endpointType) {
		super("vncproxy", "vncproxy", endpointType, new String[]{}, new String[]{});
	}
}
