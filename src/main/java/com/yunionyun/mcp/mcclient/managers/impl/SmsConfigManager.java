package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

public class SmsConfigManager extends BaseNotifyManager {
    public SmsConfigManager() {
        super("sms_config", "sms_configs", //GET请求和LIST请求的返回值
                new String[] {"type", "access_key_id", "access_key_secret", "signature",
            			"sms_template_one", "sms_template_two", "sms_template_three", "sms_check_code"},
                new String[] {});
    }
}

/*  测试的逻辑代码
 * try {
			SmsConfigManager manager = new SmsConfigManager();
			Session session = mcclientUtil.getTokenSession();
			JSONObject jsonObject = manager.Get(session, "sms_aliyun", null);
			System.out.println("testSmSConfigManager >>> jsonObject = "+jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
 * */
 