package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class MonitorTypeManager extends BaseMonitorManager {
  public MonitorTypeManager() {
    this(EndpointType.InternalURL);
  }

  public MonitorTypeManager(EndpointType endpointType) {
    super(
        "monitor_type",
        "monitor_types",
        endpointType,
        new String[] {
          "id",
          "name",
          "status",
          "create_by",
          "update_by",
          "delete_by",
          "gmt_create",
          "gmt_modified",
          "gmt_delete",
          "is_deleted",
          "project_id",
          "remark"
        },
        new String[] {});
  }
}
