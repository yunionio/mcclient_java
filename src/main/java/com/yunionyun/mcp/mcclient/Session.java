package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
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

	private String getApiVersionByServiceType(String service) {
		if (service.equals("compute")) {
			return "v2";
		}
		return null;
	}

	private String getServiceType(String service) {
		String apiVersion = this.getApiVersionByServiceType(service);
		if (apiVersion != null
				&& apiVersion.length() > 0
				&& !apiVersion.equals(DEFAULT_API_VERSION)) {
			service += "_" + apiVersion;
		}
		return service;
	}

	public String getServiceUrl(String service, EndpointType endpointType)
			throws McClientJavaBizException {
		String[] candidates = this.getServiceUrls(service, endpointType);
		int randidx = (int) (Math.random() * candidates.length);
		if (candidates.length != 0) {
			return candidates[randidx];
		} else {
			// 此种情况是服务端目录列表中没有对应的url与配置文件中传入的url进行匹配
			throw new McClientJavaBizException("服务端目录列表中没有" + service + "对应的url");
		}
	}

	public String[] getApigatewayServiceUrls(String service, String region, String zone, EndpointType endpointType) 
			throws McClientJavaBizException	{
		String[] urls = this.getServiceVersionUrls(service, region, zone, EndpointType.InternalURL);
		if (urls.length == 0) {
			// 此种情况是服务端目录列表中没有对应的url与配置文件中传入的url进行匹配
			throw new McClientJavaBizException("服务端目录列表中没有" + service + "对应的url");
		}
   
   	 	// replace URLs with authUrl prefix
    	// find the common prefix
    	String prefix = this.client.getAuthUrl();
    	int lastSlashPos = prefix.lastIndexOf("/api/s/identity");
    	if (lastSlashPos <= 0) {
			throw new McClientJavaBizException("invalue auth_url " + this.client.getAuthUrl() + ", should be url of apigateway endpoint, e.g. https://<apigateway-host>/api/s/identity/v3");
    	}
		String hostPart = prefix.substring(0, lastSlashPos);
		while (hostPart.endsWith("/")) {
			hostPart = hostPart.substring(0, hostPart.length()-1);
		}
		prefix = hostPart + "/api/s/" + service;
   		if (region != null && region.length() > 0) {
			prefix += "/r/" + region;
			if (zone != null && zone.length() > 0) {
				prefix += "/z/" + zone;
			}
	    }
    	String[] rets = new String[urls.length];
		for (int i = 0; i < urls.length; i++) {
			String url = urls[i];
			if (url == null || url.length() < 9) {
				continue;
			}
			int slashPos = url.indexOf("/", 9);
			if (slashPos > 0) {
				rets[i] = prefix + url.substring(slashPos);
			} else {
				rets[i] = prefix;
			}
		}
		return rets;
	}

	public String[] getServiceVersionUrls(String service, String region, String zone, EndpointType endpointType) 
			throws McClientJavaBizException	{
		return this.token.getServiceUrls(service, region, zone, endpointType);
	}

	public String[] getServiceUrls(String service, EndpointType endpointType)
			throws McClientJavaBizException {
		if (this.endpointType != null) {
			endpointType = this.endpointType;
		}
		service = this.getServiceType(service);
		if (endpointType.equals(EndpointType.ApigatewayURL)) {
			System.out.println("getApigatewayServiceUrls");
			return this.getApigatewayServiceUrls(service, this.region, this.zone, endpointType);
		} else {
			System.out.println("getServiceVersionUrls");
			return this.getServiceVersionUrls(service, this.region, this.zone, endpointType);
		}
	}

	public JSONObject jsonRequest(
			String service,
			EndpointType endpointType,
			String method,
			String url,
			HttpHeaders headers,
			JSONObject jsonBody)
			throws McClientJavaBizException, IOException, JSONClientException {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, endpointType));
		logger.debug("jsonRequest " + baseurl + " token " + this.token.getToken());
		HttpHeaders tmpHdr = new HttpHeaders();
		if (headers != null) {
			tmpHdr.update(headers);
		}
		tmpHdr.update(this.headers);
		return this.client.jsonRequest(baseurl, this.token.getToken(), method, url, tmpHdr, jsonBody);
	}

	public HttpURLConnection jsonRawRequest(
			String service,
			EndpointType endpointType,
			String method,
			String url,
			HttpHeaders headers,
			JSONObject jsonBody)
			throws McClientJavaBizException, IOException, JSONClientException {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, endpointType));
		logger.debug("jsonRequest " + baseurl + " token " + this.token.getToken());
		HttpHeaders tmpHdr = new HttpHeaders();
		if (headers != null) {
			tmpHdr.update(headers);
		}
		tmpHdr.update(this.headers);
		return this.client._jsonRequest(baseurl, this.token.getToken(), method, url, tmpHdr, jsonBody);
	}

	public JSONArray jsonRequestArray(String service, EndpointType endpointType, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, endpointType));
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

	public JSONObject rawRequest(
			String service,
			EndpointType endpointType,
			String method,
			String url,
			HttpHeaders headers,
			InputStream body)
			throws NoSuchAlgorithmException, McClientJavaBizException, IOException,
			KeyManagementException, JSONClientException {
		String baseurl = Utils.stripURLVersion(this.getServiceUrl(service, endpointType));
		if (this.headers != null) {
			headers.update(this.headers);
		}
		return this.client.rowBaseUrlRequest(
				baseurl, this.token.getToken(), method, url, headers, body);
	}
}
