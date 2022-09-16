package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ComputeTasksManager extends ComputeManager {
	public ComputeTasksManager() {
		this(EndpointType.InternalURL);
	}

	public ComputeTasksManager(EndpointType endpointType) {
		super(
				"task",
				"tasks",
				endpointType,
				new String[]{},
				new String[]{"Id", "Obj_name", "Obj_Id", "Task_name", "Stage", "Created_at"});
	}
}
