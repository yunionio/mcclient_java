package com.yunionyun.mcp.mcclient.managers.impl;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerCertificateManager extends ComputeManager {
	public LoadbalancerCertificateManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerCertificateManager(EndpointType endpointType) {
		super(
				"loadbalancercertificate",
				"loadbalancercertificates",
				endpointType,
				new String[]{
						"id",
						"name",
						"algorithm",
						"fingerprint",
						"not_before",
						"not_after",
						"common_name",
						"subject_alternative_names",
				},
				new String[]{"tenant"});
	}
}
