package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class RateManager extends MeterManager {
  public RateManager() {
    this(EndpointType.InternalURL);
  }

  public RateManager(EndpointType endpointType) {
    super(
        "rate",
        "rates",
        endpointType,
        new String[] {
          "id",
          "brand",
          "model",
          "res_type",
          "sub_res_type",
          "duration",
          "unit",
          "spec",
          "rate",
          "effective_date",
          "platform",
          "effective_flag"
        },
        new String[] {});
  }
}
