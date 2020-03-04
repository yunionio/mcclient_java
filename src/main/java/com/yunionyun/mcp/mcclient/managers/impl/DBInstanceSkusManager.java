package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DBInstanceSkusManager extends ComputeManager {
  public DBInstanceSkusManager() {
    this(EndpointType.InternalURL);
  }

  public DBInstanceSkusManager(EndpointType endpointType) {
    super(
        "dbinstance_sku",
        "dbinstance_skus",
        endpointType,
        new String[] {
          "Id", "Name", "Engine", "Engine_Version", "Category", "Storage_Type", "Status", "Enabled"
        },
        new String[] {});
  }
}
