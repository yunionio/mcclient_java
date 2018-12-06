package com.yunionyun.mcp.mcclient.managers.impl;


import com.yunionyun.mcp.mcclient.managers.BaseWebsocketManager;


public class WebsocketManager extends BaseWebsocketManager {
	
	public WebsocketManager() {
		super("websocket", "websockets",
				new String[] {"id", "obj_id", "obj_name", "obj_name", "priority", 
						"success", "action", "notes", "user_id", "user", "tenant_id", "tenant"},
				new String[] {});
	}


}
