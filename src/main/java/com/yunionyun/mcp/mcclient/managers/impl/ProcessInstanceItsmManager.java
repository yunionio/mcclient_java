package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseITSMManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class ProcessInstanceItsmManager extends BaseITSMManager {
	public ProcessInstanceItsmManager() {
		this(EndpointType.InternalURL);
	}

	public ProcessInstanceItsmManager(EndpointType endpointType) {
		super(
				"process-instance",
				"process-instances",
				endpointType,
				new String[]{
						"id",
						"process_instance_id",
						"root_process_instance_id",
						"case_instance_id",
						"business_key",
						"ended",
						"suspended",
						"tenant_id"
				},
				new String[]{});
	}
}
