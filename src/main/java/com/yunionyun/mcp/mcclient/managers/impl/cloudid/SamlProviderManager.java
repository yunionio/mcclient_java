package com.yunionyun.mcp.mcclient.managers.impl.cloudid;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseCloudIdManager;

public class SamlProviderManager extends BaseCloudIdManager {
    public SamlProviderManager() {
        this(EndpointType.InternalURL);
    }

    public SamlProviderManager(EndpointType endpointType) {
        super("saml_provider", "saml_providers", endpointType, null, null);
    }
}
