package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.KeystoneManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ServicesV3Manager extends KeystoneManager {
  public ServicesV3Manager() {
    this(EndpointType.AdminURL);
  }

  public ServicesV3Manager(EndpointType endpointType) {
    super(
            "service",
            "services",
            endpointType,
            new String[]{},
            new String[]{"ID", "Name", "Type", "Description"});
  }
}
