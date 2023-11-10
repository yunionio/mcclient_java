package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.common.BaseEnumConstants;

public class EndpointType extends BaseEnumConstants {

	public static final EndpointType InternalURL;
	public static final EndpointType PublicURL;
	public static final EndpointType AdminURL;
	public static final EndpointType ApigatewayURL;

	static {
		InternalURL = new EndpointType("internalURL");
		PublicURL = new EndpointType("PublicURL");
		AdminURL = new EndpointType("AdminURL");
        ApigatewayURL = new EndpointType("apigateway");
	}

	private EndpointType(String rep) {
		super(rep);
	}

	public static EndpointType string2EndpointType(String str) {
		BaseEnumConstants cont = string2Const(str);
		if (cont != null) {
			return (EndpointType) cont;
		}
		return InternalURL;
	}
}
