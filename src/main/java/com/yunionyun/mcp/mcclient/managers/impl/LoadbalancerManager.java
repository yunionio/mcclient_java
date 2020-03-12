package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerManager extends ComputeManager {
  public LoadbalancerManager() {
    this(EndpointType.InternalURL);
  }

  public LoadbalancerManager(EndpointType endpointType) {
    super(
        "loadbalancer",
        "loadbalancers",
        endpointType,
        new String[] {
          "id",
          "name",
          "status",
          "address_type",
          "address",
          "network_type",
          "network_id",
          "charge_type",
          "egress_mbps",
          "loadbalancer_spec",
          "cloudregion_id"
        },
        new String[] {"tenant"});
  }
}
