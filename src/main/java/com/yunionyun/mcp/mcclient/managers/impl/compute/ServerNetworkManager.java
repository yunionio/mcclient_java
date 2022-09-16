package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

public class ServerNetworkManager extends ComputeJointManager {
	public ServerNetworkManager() {
		this(EndpointType.InternalURL, new ServerManager(), new NetworkManager());
	}

	public ServerNetworkManager(ServerManager master, NetworkManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public ServerNetworkManager(
			EndpointType endpointType, ServerManager master, NetworkManager slave) {
		super(
				"guestnetwork",
				"guestnetworks",
				endpointType,
				new String[]{
						"bw_limit",
						"created_at",
						"driver",
						"guest_id",
						"ifname",
						"index",
						"ip_addr",
						"mac_addr",
						"network_id",
						"update_version",
						"updated_at",
						"virtual"
				},
				new String[]{},
				master,
				slave);
	}
}
