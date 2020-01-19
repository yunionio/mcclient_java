package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ContactsManager extends BaseNotifyManager {
    public ContactsManager() {
        this(EndpointType.InternalURL);
    }

    public ContactsManager(EndpointType endpointType){
        super("contact", "contacts",endpointType,
                new String[]{"id", "name", "display_name", "details", "status", "create_by", "update_by", "delete_by", "gmt_create", "gmt_modified", "gmt_delete", "project_id", "remark"},
                new String[]{});
    }
}
