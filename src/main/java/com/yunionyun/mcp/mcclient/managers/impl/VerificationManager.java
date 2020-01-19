package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class VerificationManager extends BaseNotifyManager {
    public VerificationManager() {
        this(EndpointType.InternalURL);
    }

    public VerificationManager(EndpointType endpointType){
        super("verification", "verifications", endpointType,
                new String[]{"id", "cid", "sent_at", "expire_at", "status", "create_at", "update_at", "delete_at", "create_by", "update_by", "delete_by", "is_deleted", "remark"},
                new String[]{});
    }
}
