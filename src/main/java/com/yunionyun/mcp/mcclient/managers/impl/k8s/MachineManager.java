package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class MachineManager extends BaseKubeserverManager {
	public MachineManager() {
		this(EndpointType.InternalURL);
	}

	public MachineManager(EndpointType endpointType) {
		super(
				"kubemachine",
				"kubemachines",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
