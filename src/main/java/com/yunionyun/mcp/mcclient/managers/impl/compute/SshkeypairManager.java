package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class SshkeypairManager extends ComputeManager {
	public SshkeypairManager() {
		this(EndpointType.InternalURL);
	}

	public SshkeypairManager(EndpointType endpointType) {
		super("sshkeypair", "sshkeypairs", endpointType, new String[]{}, new String[]{});
	}
}
