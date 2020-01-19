package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseMonitorManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class RecipientsManager extends BaseMonitorManager {
    public RecipientsManager() {
        this(EndpointType.InternalURL);
    }


    public RecipientsManager(EndpointType endpointType){
        super("recipient", "recipients", endpointType,
                new String[]{"id", "type", "details", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "is_deleted", "project_id", "remark"},
                new String[]{});
    }
}
