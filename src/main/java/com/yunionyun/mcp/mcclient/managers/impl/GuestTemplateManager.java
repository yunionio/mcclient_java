package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class GuestTemplateManager extends ComputeManager {
  public GuestTemplateManager() {
    this(EndpointType.InternalURL);
  }

  public GuestTemplateManager(EndpointType endpointType) {
    super(
        "servertemplate",
        "servertemplates",
        endpointType,
        new String[] {"ID", "Name", "Public_Scope", "Is_Public", "Project_Id", "Content"},
        new String[] {});
  }
}
