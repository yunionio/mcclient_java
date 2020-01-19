package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class HostwireManager extends ComputeJointManager {
    public HostwireManager(HostManager master, WireManager slave) {
        this(EndpointType.InternalURL,master,slave);

    }

    public HostwireManager(EndpointType endpointType, HostManager master, WireManager slave) {
        super("hostwire", "hostwires", endpointType,
                new String[]{"Host_ID", "Host", "Wire_ID", "Wire", "Bridge", "Interface", "Mac_addr", "is_master"},
                new String[]{}, master, slave);

    }
}
