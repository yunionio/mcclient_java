package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class VirtualMachineManager extends BaseKubeserverManager {
	public VirtualMachineManager() {
		this(EndpointType.InternalURL);
	}

	public VirtualMachineManager(EndpointType endpointType) {
		super(
				"virtualmachine",
				"virtualmachines",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
