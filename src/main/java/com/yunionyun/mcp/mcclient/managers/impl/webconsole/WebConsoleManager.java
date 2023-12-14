package com.yunionyun.mcp.mcclient.managers.impl.webconsole;

import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.managers.BaseWebConsoleManager;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.*;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

import java.io.IOException;
import java.io.*;

/**
 * @author zxc
 * @date 2020/01/19
 */
public class WebConsoleManager extends BaseWebConsoleManager {
	public WebConsoleManager() {
		this(EndpointType.InternalURL);
	}

	public WebConsoleManager(EndpointType endpointType) {
		super("webconsole", "webconsole", endpointType, new String[]{}, new String[]{});
	}

	public JSONObject DoConnect(Session s, String connType, String id, String action, JSONObject params)
		throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/webconsole/");
		url.append(connType);
		if (id != null && id.length() > 0) {
			url.append("/");
			url.append(id);
		}
		if (action != null && action.length() > 0) {
			url.append("/");
			url.append(action);
		}
		JSONObject body = new JSONObject();
		if (params != null) {
			body.put("webconsole", params);
		}
		System.out.println(url.toString() + body.toString());
		return this._post(s, url.toString(), body, "webconsole");
	}

	/**
	 * @param s			Session, client session, required
	 * @param id		Id of server to connect, required
	 * @param ip    	IP to connect, optional for server with single IP
	 * @param port  	Port number to connect, optional if the port is 22
	 * @param username 	username to login, optional
	 * @param password 	password for the user, optional
	 */
	public JSONObject DoSshConnect(Session s, String id, String ip, int port, String username, String password)
		throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject params = new JSONObject();
		if (ip != null && ip.length() > 0) {
			params.put("ip", ip);
		}
		if (port > 0) {
			params.put("port", port);
		}
		if (username != null && username.length() > 0) {
			params.put("username", username);
		}
		if (password != null && password.length() > 0) {
			params.put("password", password);
		}
		return this.DoConnect(s, "ssh", id, "", params);
	}

	/**
	 * @param s			Session, client session, required
	 * @param id		Id of server to connect, required
	 * @param host    	Host to connect, optional for server with single IP
	 * @param port  	Port number to connect, optional if the port is 3389
	 * @param username 	username to login, optional
	 * @param password 	password for the user, optional
	 */
	public JSONObject DoRdpConnect(Session s, String id, String ip, int port, String username, String password)
		throws McClientJavaBizException, IOException, JSONClientException {
		JSONObject params = new JSONObject();
		if (ip != null && ip.length() > 0) {
			params.put("host", ip);
		}
		if (port > 0) {
			params.put("port", port);
		}
		if (username != null && username.length() > 0) {
			params.put("username", username);
		}
		if (password != null && password.length() > 0) {
			params.put("password", password);
		}
		return this.DoConnect(s, "server-rdp", id, "", params);
	}
}
