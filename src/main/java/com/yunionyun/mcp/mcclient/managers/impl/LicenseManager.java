package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.YunionAgentManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LicenseManager extends YunionAgentManager {
    public LicenseManager() {
        this(EndpointType.InternalURL);
    }

    public LicenseManager(EndpointType endpointType) {
        super("license", "licenses", endpointType, new String[]{}, new String[]{});
    }
}
