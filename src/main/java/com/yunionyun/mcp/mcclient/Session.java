package com.yunionyun.mcp.mcclient;

import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;

public class Session {
	private Client client;
	private String region;
	private String zone;
	private String endpointType;
	private TokenCredential token;
	private HttpHeaders headers;
	
	public static final String TASK_NOTIFY_URL_HEAD = "X-Task-Notify-Url";
	
	public Session(Client cli, String region, String zone, String endpointType, TokenCredential token) {
		this.client = cli;
		this.region = region;
		this.zone = region;
		this.endpointType = endpointType;
		this.token = token;
		this.headers = new HttpHeaders();
	}
	
	public void setHeader(String key, String value) {
		this.headers.set(key, value);
	}
	
	public void removeHeader(String key) {
		this.headers.remove(key);
	}
	
	public String getHeader(String key) {
		return this.headers.get(key);
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
		HttpHeaders tmpHdr = new HttpHeaders();
		if (headers != null) {
			tmpHdr.update(headers);
		}
		tmpHdr.update(this.headers);
		return this.client.jsonRequest(baseurl, this.token.getToken(), method, url, tmpHdr, jsonBody);
	}
	
	public boolean isSystemAdmin() {
	    return this.token.isSystemAdmin();
	}

	public String getProjectId() {
	    return this.token.getProjectId();
	}

	public void setTaskNotifyUrl(String url) {
		this.setHeader(TASK_NOTIFY_URL_HEAD, url);
	}
	
	public void clearTaskNotifyUrl() {
		this.removeHeader(TASK_NOTIFY_URL_HEAD);
	}
}
