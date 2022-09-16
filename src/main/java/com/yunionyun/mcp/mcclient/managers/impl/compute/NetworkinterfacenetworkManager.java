package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NetworkinterfacenetworkManager extends ComputeJointManager {
	public NetworkinterfacenetworkManager(NetworkinterfaceManager master, NetworkManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public NetworkinterfacenetworkManager(
			EndpointType endpointType, NetworkinterfaceManager master, NetworkManager slave) {
		super(
				"networkinterfacenetwork",
				"networkinterfacenetworks",
				endpointType,
				new String[]{
						"Networkinterface_ID", "Networkinterface", "Network_ID", "Network", "IP_Addr", "Primary"
				},
				new String[]{},
				master,
				slave);
	}
}
