package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedtagnetworkManager extends ComputeJointManager {
  public SchedtagnetworkManager(SchedTagManager master, NetworkManager slave) {
    this(EndpointType.InternalURL, master, slave);
  }

  public SchedtagnetworkManager(
      EndpointType endpointType, SchedTagManager master, NetworkManager slave) {
    super(
        "schedtagnetwork",
        "schedtagnetworks",
        endpointType,
        new String[] {"Network_ID", "Network", "Schedtag_ID", "Schedtag"},
        new String[] {},
        master,
        slave);
  }
}
