package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

public class SmsConfigManager extends BaseNotifyManager {
    public SmsConfigManager() {
        this(EndpointType.InternalURL);
    }

    public SmsConfigManager(EndpointType endpointType) {
        super("sms_config", "sms_configs", endpointType,
                new String[] {"type", "access_key_id", "access_key_secret", "signature",
                        "sms_template_one", "sms_template_two", "sms_template_three", "sms_check_code"},
                new String[] {});
    }
}


 