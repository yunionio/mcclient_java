package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.managers.BaseNotifyManager;

public class EmailConfigManager extends BaseNotifyManager {
    public EmailConfigManager() {
        super("email_config", "email_configs", //GET请求和LIST请求的返回值
                new String[] {"username", "password", "hostname", "ssl_global", "hostport"},
                new String[] {});
    }
}
/** 参考的测试代码
 * EmailConfigManager manager = new EmailConfigManager();
   Session session = mcclientUtil.getTokenSession();
   JSONObject jsonObject = manager.Get(session, "email", null);
   System.out.println("\n\n testConfigManager >>> jsonObject = "+jsonObject);
 * */
