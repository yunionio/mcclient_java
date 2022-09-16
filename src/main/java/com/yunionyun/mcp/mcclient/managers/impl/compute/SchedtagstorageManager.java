package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeJointManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SchedtagstorageManager extends ComputeJointManager {
	public SchedtagstorageManager(SchedTagManager master, StorageManager slave) {
		this(EndpointType.InternalURL, master, slave);
	}

	public SchedtagstorageManager(
			EndpointType endpointType, SchedTagManager master, StorageManager slave) {
		super(
				"schedtagstorage",
				"schedtagstorages",
				endpointType,
				new String[]{"Storage_ID", "Storage", "Schedtag_ID", "Schedtag"},
				new String[]{},
				master,
				slave);
	}
}
