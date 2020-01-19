package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class NotifyTemplateManager extends BaseNotifyManager {
    public NotifyTemplateManager() {
        this(EndpointType.InternalURL);
    }

    public NotifyTemplateManager(EndpointType endpointType){
        super("notifytemplate", "notifytemplates", endpointType,
                new String[]{"Contact_Type", "Topic", "Template_Type"},
                new String[]{});
    }
}
