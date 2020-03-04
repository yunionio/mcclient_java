package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.MeterManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class ResResultManager extends MeterManager {
	public ResResultManager() {
		this(EndpointType.InternalURL);
	}

	public ResResultManager(EndpointType endpointType) {
		super(
				"res_result",
				"res_results",
				endpointType,
				new String[]{
						"res_id",
						"res_name",
						"cpu",
						"mem",
						"sys_disk",
						"data_disk",
						"ips",
						"res_type",
						"band_width",
						"os_distribution",
						"os_version",
						"platform",
						"region_id",
						"project_name",
						"user_name",
						"start_time",
						"end_time",
						"time_length",
						"cpu_amount",
						"mem_amount",
						"disk_amount",
						"baremetal_amount",
						"gpu_amount",
						"res_fee"
				},
				new String[]{});
	}
}
