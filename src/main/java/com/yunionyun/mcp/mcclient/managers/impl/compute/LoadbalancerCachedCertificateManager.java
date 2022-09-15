package com.yunionyun.mcp.mcclient.managers.impl.compute;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;

/**
 * @author zxc
 * @date 2020/01/18
 */
public class LoadbalancerCachedCertificateManager extends ComputeManager {
	public LoadbalancerCachedCertificateManager() {
		this(EndpointType.InternalURL);
	}

	public LoadbalancerCachedCertificateManager(EndpointType endpointType) {
		super(
				"cachedloadbalancercertificate",
				"cachedloadbalancercertificates",
				endpointType,
				new String[]{
						"id",
						"certificate_id",
						"name",
						"algorithm",
						"fingerprint",
						"not_before",
						"not_after",
						"common_name",
						"subject_alternative_names"
				},
				new String[]{"tenant"});
	}
}
