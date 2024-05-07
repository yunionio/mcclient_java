package com.yunionyun.mcp.mcclient.managers.impl.k8s;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseKubeserverManager;

/**
 * @author qiujian
 * @date 2024/05/07
 */
public class RoleBindingManager extends BaseKubeserverManager {
	public RoleBindingManager() {
		this(EndpointType.InternalURL);
	}

	public RoleBindingManager(EndpointType endpointType) {
		super(
				"rbacrolebinding",
				"rbacrolebindings",
				endpointType,
				new String[]{
				},
				new String[]{});
	}
}
