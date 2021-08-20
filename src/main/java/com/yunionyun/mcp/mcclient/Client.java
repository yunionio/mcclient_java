package com.yunionyun.mcp.mcclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.keystone.TokenCredential;
import com.yunionyun.mcp.mcclient.utils.LocalSslUtils;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;
import org.slf4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class Client {
	public static final String USER_AGENT = "yunioncloud-java/201711";
	private static Logger logger = LoggerUtils.createLoggerFor(Client.class.getName());
	private String authUrl;
	private int timeout;
	private boolean debug;
	private boolean inSecure;

	public Client(String authUrl, int timeout, boolean debug, boolean insecure) {
		this.authUrl = authUrl;
		this.timeout = timeout;
		this.debug = debug;
		this.inSecure = insecure;
	}

	private HttpURLConnection rawRequest(
			String endpoint,
			String token,
			String method,
			String url,
			HttpHeaders headers,
			InputStream body)
			throws IOException, KeyManagementException, NoSuchAlgorithmException {
		method = method.toUpperCase();

		if (this.debug) {
			logger.debug(method + " " + endpoint + url);
		}
		URL requrl = new URL(joinUrl(endpoint, url));

		if (requrl.getProtocol().equals("https") && this.inSecure) {
			Utils.disableHttpsVerification();
		}
		if ("https".equalsIgnoreCase(requrl.getProtocol())) {
			LocalSslUtils.ignoreSsl();
		}
		HttpURLConnection req = (HttpURLConnection) requrl.openConnection();
		// req.setRequestMethod(method);
		Utils.setHttpRequestMethod(req, method);
		req.setRequestProperty("User-Agent", USER_AGENT);
		req.setInstanceFollowRedirects(false);
		req.setConnectTimeout(this.timeout * 1000);
		req.setReadTimeout(this.timeout * 1000);
		req.setUseCaches(false);
		if (token != null && token.length() > 0) {
			req.setRequestProperty("X-Auth-Token", token);
		}

		if (headers != null) {
			headers.setHeaders(req);
		}

		boolean input = true;
		if (method.equals("HEAD")) {
			input = false;
		}
		boolean output = false;
		if (body != null) {
			if (headers == null || !headers.has("Content-Length")) {
				req.setChunkedStreamingMode(1000);
			}
			output = true;
		} else {
			if (headers == null || !headers.has("Cotent-Length")) {
				req.setRequestProperty("Content-Length", "0");
			}
		}

		req.setDoInput(input);
		req.setDoOutput(output);

		if (output) {
			byte[] buffer = new byte[4096];
			DataOutputStream wr = new DataOutputStream(req.getOutputStream());
			int rn = body.read(buffer);
			while (rn != -1) {
				if (rn > 0) {
					wr.write(buffer, 0, rn);
				}
				rn = body.read(buffer);
			}
			wr.flush();
			wr.close();
		}

		return req;
	}

	private String _inputStream2String(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		input.close();
		return response.toString();
	}

	public JSONObject jsonRequest(
			String endpoint,
			String token,
			String method,
			String url,
			HttpHeaders headers,
			JSONObject jsonBody)
			throws IOException, JSONClientException {
		return this.parseJSONResult(this._jsonRequest(endpoint, token, method, url, headers, jsonBody));
	}

	public JSONArray jsonRequestArray(String endpoint, String token, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
		return (JSONArray) this.parseJSONResult(this._jsonRequest(endpoint, token, method, url, headers, jsonBody), "array");
	}

	public JSONObject rowBaseUrlRequest(
			String endpoint,
			String token,
			String method,
			String url,
			HttpHeaders headers,
			InputStream body)
			throws IOException, JSONClientException, NoSuchAlgorithmException, KeyManagementException {
		return this.parseJSONResult(rawRequest(endpoint, token, method, url, headers, body));
	}

	private HttpURLConnection _jsonRequest(
			String endpoint,
			String token,
			String method,
			String url,
			HttpHeaders headers,
			JSONObject jsonBody)
			throws JSONClientException {
		String bodyStr = null;
		int contlen = 0;

		if (jsonBody != null) {
			bodyStr = jsonBody.toString();
			contlen = bodyStr.length();
		}

		if (headers == null) {
			headers = new HttpHeaders();
		}

		headers.set("Content-Type", "application/json");
		headers.set("Content-Length", "" + contlen);

		try {
			InputStream input = null;
			if (bodyStr != null) {
				input = new ByteArrayInputStream(bodyStr.getBytes(StandardCharsets.UTF_8.name()));
			}
			HttpURLConnection req = this.rawRequest(endpoint, token, method, url, headers, input);
			return req;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JSONClientException(499, "", e.getMessage());
		}
	}

	private JSONObject parseJSONResult(HttpURLConnection req)
			throws IOException, JSONClientException {
		int code = req.getResponseCode();
		req.getErrorStream();
		InputStream input = null;
		if (req.getResponseCode() >= 400) {
			input = req.getErrorStream();
		} else {
			input = req.getInputStream();
		}
		String textResult = null;
		JSONObject jsonResult = null;
		if (input != null) {
			textResult = _inputStream2String(input);
			if (this.debug) {
				logger.debug("Response code: " + code);
				logger.debug("Response: " + textResult);
			}
			try {
				jsonResult = JSONObject.parseObject(textResult);
			} catch (Exception e) {
				throw new JSONClientException(499, "Malformed JSON body", textResult);
			}
		} else {
			if (this.debug) {
				logger.debug("jsonRequest: no body");
			}
		}
		if (code >= 200 && code < 300) {
			return jsonResult;
		} else if (code >= 300 && code < 400) {
			throw new JSONClientException(code, "redirect", req.getHeaderField("Location"));
		} else if (jsonResult != null) {
			if (jsonResult.containsKey("error")) {
				JSONObject errBody = jsonResult.getJSONObject("error");
				if (errBody.containsKey("message")
						&& errBody.containsKey("title")
						&& errBody.containsKey("code")) {
					throw new JSONClientException(
							errBody.getIntValue("code"),
							errBody.getString("title"),
							errBody.getString("message"));
				} else if (errBody.containsKey("code") && errBody.containsKey("details")) {
					String errCls = req.getResponseMessage();
					if (errBody.containsKey("class")) {
						errCls = errBody.getString("class");
					}
					throw new JSONClientException(
							errBody.getIntValue("code"), errCls, errBody.getString("details"));
				} else {
					throw new JSONClientException(code, req.getResponseMessage(), errBody.toString());
				}
			} else {
				throw new JSONClientException(code, req.getResponseMessage(), jsonResult.toString());
			}
		} else if (textResult != null) {
			throw new JSONClientException(code, req.getResponseMessage(), textResult);
		} else {
			throw new JSONClientException(code, req.getResponseMessage(), req.getResponseMessage());
		}
	}

	/**
	 * @param req
	 * @param type 根据type 判断返回值类型：array-JsonArray；others-JsonObject
	 * @return
	 * @throws Exception
	 */
	private JSON parseJSONResult(HttpURLConnection req, String type) throws Exception {
		int code = req.getResponseCode();
		req.getErrorStream();
		InputStream input = null;
		if (req.getResponseCode() >= 400) {
			input = req.getErrorStream();
		} else {
			input = req.getInputStream();
		}

		String textResult = null;
		JSON jsonResult = null;
		if (input != null) {
			textResult = this._inputStream2String(input);
			if (this.debug) {
				logger.debug("Response code: " + code);
				logger.debug("Response: " + textResult);
			}

			try {
				if (type != null && "array".equalsIgnoreCase(type)) {
					jsonResult = JSONObject.parseArray(textResult);
				} else {
					jsonResult = JSONObject.parseObject(textResult);
				}
			} catch (Exception var10) {
				throw new JSONClientException(499, "Malformed JSON body", textResult);
			}
		} else if (this.debug) {
			logger.debug("jsonRequest: no body");
		}

		if (code >= 200 && code < 300) {
			return (JSON) jsonResult;
		} else if (code >= 300 && code < 400) {
			throw new JSONClientException(code, "redirect", req.getHeaderField("Location"));
		} else if (jsonResult != null) {
			if (jsonResult instanceof JSONObject) {
				JSONObject obj = (JSONObject) jsonResult;
				if (obj.containsKey("error")) {
					JSONObject errBody = obj.getJSONObject("error");
					if (errBody.containsKey("message") && errBody.containsKey("title") && errBody.containsKey("code")) {
						throw new JSONClientException(errBody.getIntValue("code"), errBody.getString("title"), errBody.getString("message"));
					} else if (errBody.containsKey("code") && errBody.containsKey("details")) {
						String errCls = req.getResponseMessage();
						if (errBody.containsKey("class")) {
							errCls = errBody.getString("class");
						}

						throw new JSONClientException(errBody.getIntValue("code"), errCls, errBody.getString("details"));
					} else {
						throw new JSONClientException(code, req.getResponseMessage(), errBody.toString());
					}
				} else {
					throw new JSONClientException(code, req.getResponseMessage(), ((JSON) jsonResult).toString());
				}
			} else {
				return null;
			}
		} else if (textResult != null) {
			throw new JSONClientException(code, req.getResponseMessage(), textResult);
		} else {
			throw new JSONClientException(code, req.getResponseMessage(), req.getResponseMessage());
		}
	}

	private TokenCredential _auth(
			String domainName,
			String userName,
			String passwd,
			String projectId,
			String projectName,
			String projectDomain,
			String token)
			throws JSONClientException, McClientJavaBizException, IOException {
		JSONObject body = new JSONObject();
		if (userName != null && passwd != null && userName.length() > 0 && passwd.length() > 0) {
			Utils.JSONAdd(
					body,
					Utils.stringArray2JSONArray(new String[]{"password"}),
					"auth",
					"identity",
					"methods");
			Utils.JSONAdd(body, userName, "auth", "identity", "password", "user", "name");
			Utils.JSONAdd(body, passwd, "auth", "identity", "password", "user", "password");
			if (domainName != null && domainName.length() > 0) {
				Utils.JSONAdd(body, domainName, "auth", "identity", "password", "user", "domain", "name");
			} else {
				Utils.JSONAdd(body, "default", "auth", "identity", "password", "user", "domain", "id");
			}
		} else if (token != null && token.length() > 0) {
			Utils.JSONAdd(
					body, Utils.stringArray2JSONArray(new String[]{"token"}), "auth", "identity", "methods");
			Utils.JSONAdd(body, token, "auth", "identity", "token", "id");
		}
		if (projectId != null && projectId.length() > 0) {
			Utils.JSONAdd(body, projectId, "auth", "scope", "project", "id");
		}
		if (projectName != null && projectName.length() > 0) {
			if (projectDomain == null || projectDomain.length() == 0) {
				Utils.JSONAdd(body, "default", "auth", "scope", "project", "domain", "id");
			} else {
				Utils.JSONAdd(body, projectDomain, "auth", "scope", "project", "domain", "name");
			}
			Utils.JSONAdd(body, projectName, "auth", "scope", "project", "name");
		}
		HttpURLConnection req =
				this._jsonRequest(this.authUrl, null, "POST", "/auth/tokens", null, body);
		String subjectId = req.getHeaderField("X-Subject-Token");
		if (subjectId == null || subjectId.length() == 0) {
			throw new McClientJavaBizException("Invalid token response from keystone");
		}
		TokenCredential cred = new TokenCredential(subjectId);
		JSONObject result = this.parseJSONResult(req);
		cred.parseJSON(result);
		return cred;
	}

	public TokenCredential Authenticate(String user, String passwd, String domain, String project)
			throws JSONClientException, McClientJavaBizException, IOException {
		return this._auth(domain, user, passwd, null, project, null, null);
	}
	
	public TokenCredential Authenticate(String user, String passwd, String domain, String project, String projectDomain)
			throws JSONClientException, McClientJavaBizException, IOException {
		return this._auth(domain, user, passwd, null, project, projectDomain, null);
	}

	public TokenCredential SwitchProject(String projectId, String projectName, TokenCredential token)
			throws JSONClientException, McClientJavaBizException, IOException {
		return this._auth(null, null, null, projectId, projectName, null, token.getToken());
	}
	
	public TokenCredential SwitchProject(String projectId, String projectName, String projectDomain, TokenCredential token)
			throws JSONClientException, McClientJavaBizException, IOException {
		return this._auth(null, null, null, projectId, projectName, projectDomain, token.getToken());
	}

	public TokenCredential Verify(String adminToken, String token)
			throws IOException, JSONClientException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Subject-Token", token);
		headers.set("X-Auth-Token", adminToken);
		JSONObject result = this.jsonRequest(this.authUrl, null, "GET", "/auth/tokens", headers, null);
		TokenCredential cred = new TokenCredential(token);
		cred.parseJSON(result);
		return cred;
	}

	public Session newSession(
			String region,
			String zone,
			EndpointType endpointType,
			TokenCredential token,
			String apiVersion) {
		return new Session(this, region, zone, endpointType, token, apiVersion);
	}

	public String joinUrl(String endpoint, String path) {
		int endindex = endpoint.length() - 1;
		String base = "", version = "";
		for (; endindex >= 0 && endpoint.charAt(endindex) == '/'; endindex--) {

		}
		int lastslash = endpoint.substring(0, endindex + 1).lastIndexOf('/');
		if (lastslash > 0) {
			if ("latest".equalsIgnoreCase(endpoint.substring(lastslash + 1, endindex + 1))) {
				base = endpoint.substring(0, lastslash);
			} else {
				if (Pattern.matches("^v\\d+\\.?\\d*", endpoint.substring(lastslash + 1, endindex + 1))) {
					base = endpoint.substring(0, lastslash);
					version = endpoint.substring(lastslash + 1, endindex + 1);
				}
			}

		} else {
			base = endpoint.substring(0, endindex + 1);
		}
		if (version.length() > 0) {
			if (path.startsWith(String.format("/%s/", version))) {
				endpoint = base;
			}
		}
		return String.format("%s%s", endpoint, path);
	}
}
