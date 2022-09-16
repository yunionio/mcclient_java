package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class BaremetalnetworkManager extends ComputeJointManager {
	public BaremetalnetworkManager(HostManager master, NetworkManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public BaremetalnetworkManager(
			EndpointType endpointType, HostManager master, NetworkManager slave) {
		super(
				"baremetalnetwork",
				"baremetalnetworks",
				endpointType,
				new String[]{
						"Baremetal_ID", "Host", "Network_ID", "Network", "IP_addr", "Mac_addr", "Nic_Type"
				},
				new String[]{},
				master,
				slave);
	}
}
