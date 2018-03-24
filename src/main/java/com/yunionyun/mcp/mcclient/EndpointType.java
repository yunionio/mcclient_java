package com.yunionyun.mcp.mcclient;

import com.yunionyun.mcp.mcclient.common.BaseEnumConstants;

public class EndpointType extends BaseEnumConstants{

	private EndpointType(String rep) {
		super(rep);
	}
	
	public static final EndpointType InternalURL;
	public static final EndpointType PublicURL;
	public static final EndpointType AdminURL;
	
	static {
		InternalURL = new EndpointType("internalURL");
		PublicURL = new EndpointType("PublicURL");
		AdminURL = new EndpointType("AdminURL");
	}
	
	public static EndpointType string2EndpointType(String str) {
		BaseEnumConstants cont = string2Const(str);
		if (cont != null) {
			return (EndpointType) cont;
		}
		return InternalURL;
	}
}
