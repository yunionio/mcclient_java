package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class WorkerManager extends ComputeManager {
	public WorkerManager() {
		this(EndpointType.InternalURL);
	}

	public WorkerManager(EndpointType endpointType) {
		super(
				"workers",
				"worker_stats",
				endpointType,
				new String[]{
						"name", "queue_cnt", "active_worker_cnt", "backlog", "detach_worker_cnt", "max_worker_cnt"
				},
				new String[]{});
	}
}
