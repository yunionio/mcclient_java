package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class EventManager extends BaseKubeserverManager {
	public EventManager() {
		this(EndpointType.InternalURL);
	}

	public EventManager(EndpointType endpointType) {
		super(
				"k8s_event",
				"k8s_events",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
