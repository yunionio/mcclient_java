package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.AnsibleManager;

/**
 * @author zxc
 * @date 2020/01/17
 */
public class AnsiblePlaybookV2Manager extends AnsibleManager {
	public AnsiblePlaybookV2Manager() {
		this(EndpointType.InternalURL);
	}

	public AnsiblePlaybookV2Manager(EndpointType endpointType) {
		super(
				"ansibleplaybook_v2",
				"ansibleplaybooks_v2",
				endpointType,
				new String[]{"id", "name", "status", "start_time", "end_time"},
				new String[]{});
	}
}
