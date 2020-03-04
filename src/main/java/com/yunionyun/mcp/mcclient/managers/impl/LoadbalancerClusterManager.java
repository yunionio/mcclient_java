package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerClusterManager extends ComputeManager {
  public LoadbalancerClusterManager() {
    this(EndpointType.InternalURL);
  }

  public LoadbalancerClusterManager(EndpointType endpointType) {
    super(
        "loadbalancercluster",
        "loadbalancerclusters",
        endpointType,
        new String[] {"id", "name", "zone_id", "wire_id"},
        new String[] {});
  }
}
