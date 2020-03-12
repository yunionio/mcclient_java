package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseDevtoolManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class DevToolCronjobManager extends BaseDevtoolManager {
  public DevToolCronjobManager() {
    this(EndpointType.InternalURL);
  }

  public DevToolCronjobManager(EndpointType endpointType) {
    super(
        "devtool_cronjob",
        "devtool_cronjobs",
        endpointType,
        new String[] {
          "id",
          "ansible_playbook_id",
          "template_id",
          "server_id",
          "name",
          "day",
          "hour",
          "min",
          "sec",
          "interval",
          "start",
          "enabled",
          "created_at"
        },
        new String[] {});
  }
}
