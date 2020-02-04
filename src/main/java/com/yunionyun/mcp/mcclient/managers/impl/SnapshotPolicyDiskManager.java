package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SnapshotPolicyDiskManager extends ComputeJointManager {
    public SnapshotPolicyDiskManager(DiskManager master, SnapshotPoliciyManager slave) {
        this(EndpointType.InternalURL,master,slave);
    }

    public SnapshotPolicyDiskManager(EndpointType endpointType,DiskManager master, SnapshotPoliciyManager slave){
        super("snapshotpolicydisk", "snapshotpolicydisks", endpointType,
                new String[]{"Disk_ID", "Snapshotpolicy_ID"},
                new String[]{},master,slave);
    }
}
