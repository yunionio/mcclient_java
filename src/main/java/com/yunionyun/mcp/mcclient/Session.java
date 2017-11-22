package com.yunionyun.mcp.mcclient;

import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;

public class Session {
	private Client client;
	private String region;
	private String zone;
	private String endpointType;
	private TokenCredential token;
	
	public Session(Client cli, String region, String zone, String endpointType, TokenCredential token) {
		this.client = cli;
		this.region = region;
		this.zone = region;
		this.endpointType = endpointType;
		this.token = token;
	}
	
	public String getServiceUrl(String service, String endpointType) throws Exception {
		if (this.endpointType != null && this.endpointType.length() > 0) {
			endpointType = this.endpointType;
		}
		System.out.println("getServiceUrl " + service + " epType " + endpointType);
		return this.token.getServiceUrl(service, this.region, this.zone, endpointType);
	}
	
	public JSONObject jsonRequest(String service, String endpointType, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, endpointType));
		System.out.println("jsonRequest " + baseurl + " token " +  this.token.getToken());
		return this.client.jsonRequest(baseurl, this.token.getToken(), method, url, headers, jsonBody);
	}
	
	public boolean isSystemAdmin() {
	    return this.token.isSystemAdmin();
	}

	public String getProjectId() {
	    return this.token.getProjectId();
	}
}
