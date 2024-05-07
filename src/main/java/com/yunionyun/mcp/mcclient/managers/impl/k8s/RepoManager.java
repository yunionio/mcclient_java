package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class RepoManager extends BaseKubeserverManager {
	public RepoManager() {
		this(EndpointType.InternalURL);
	}

	public RepoManager(EndpointType endpointType) {
		super(
				"repo",
				"repos",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
