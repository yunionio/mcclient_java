package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Session {
	public static final String TASK_NOTIFY_URL_HEAD = "X-Task-Notify-Url";
	public static final String DEFAULT_API_VERSION = "v1";
	private static Logger logger = LoggerUtils.createLoggerFor(Session.class.getName());
	private Client client;
	private String region;
	private String zone;
	private EndpointType endpointType;
	private TokenCredential token;
	private HttpHeaders headers;

	public Session(
			Client cli,
			String region,
			String zone,
			EndpointType endpointType,
			TokenCredential token) {
		this.client = cli;
		this.region = region;
		this.zone = zone;
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

	private String getServiceType(String service, String apiVersion) {
		if (apiVersion != null
				&& apiVersion.length() > 0
				&& !apiVersion.equals(DEFAULT_API_VERSION)) {
			service += "_" + apiVersion;
		}
		return service;
	}

	public String getServiceUrl(String service, String apiVersion, EndpointType endpointType)
			throws McClientJavaBizException {
		if (this.endpointType != null) {
			endpointType = this.endpointType;
		}
		// logger.debug("getServiceUrl " + service + " epType " + endpointType);
		return this.token.getServiceUrl(
				this.getServiceType(service, apiVersion), this.region, this.zone, endpointType);
	}

	public String[] getServiceUrls(String service, String apiVersion, EndpointType endpointType)
			throws McClientJavaBizException {
		if (this.endpointType != null) {
			endpointType = this.endpointType;
		}
		// logger.debug("getServiceUrl " + service + " epType " + endpointType);
		return this.token.getServiceUrls(
				this.getServiceType(service, apiVersion), this.region, this.zone, endpointType);
	}

	public JSONObject jsonRequest(
			String service,
			String apiVersion,
			EndpointType endpointType,
			String method,
			String url,
			HttpHeaders headers,
			JSONObject jsonBody)
			throws McClientJavaBizException, IOException, JSONClientException {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, apiVersion, endpointType));
		logger.debug("jsonRequest " + baseurl + " token " + this.token.getToken());
		HttpHeaders tmpHdr = new HttpHeaders();
		if (headers != null) {
			tmpHdr.update(headers);
		}
		tmpHdr.update(this.headers);
		return this.client.jsonRequest(baseurl, this.token.getToken(), method, url, tmpHdr, jsonBody);
	}

	public JSONArray jsonRequestArray(String service, String apiVersion, EndpointType endpointType, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, apiVersion, endpointType));
		logger.debug("jsonRequestArray " + baseurl + " token " + this.token.getToken());
		HttpHeaders tmpHdr = new HttpHeaders();
		if (headers != null) {
			tmpHdr.update(headers);
		}

		tmpHdr.update(this.headers);
		return this.client.jsonRequestArray(baseurl, this.token.getToken(), method, url, tmpHdr, jsonBody);
	}

	public boolean isSystemAdmin() {
		return this.token.isSystemAdmin();
	}

	public String getProjectId() {
		return this.token.getProjectId();
	}

	public String getProjectDomainId() {
		return this.token.getProjectDomainId();
	}

	public void setTaskNotifyUrl(String url) {
		this.setHeader(TASK_NOTIFY_URL_HEAD, url);
	}

	public void clearTaskNotifyUrl() {
		this.removeHeader(TASK_NOTIFY_URL_HEAD);
	}

	public JSONObject rowRequest(
			String service,
			String apiVersion,
			EndpointType endpointType,
			String method,
			String url,
			HttpHeaders headers,
			InputStream body)
			throws NoSuchAlgorithmException, McClientJavaBizException, IOException,
			KeyManagementException, JSONClientException {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, apiVersion, endpointType));
		if (this.headers != null) {
			headers.update(this.headers);
		}
		return this.client.rowBaseUrlRequest(
				baseurl, this.token.getToken(), method, url, headers, body);
	}
}
