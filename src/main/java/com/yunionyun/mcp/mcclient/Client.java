package com.yunionyun.mcp.mcclient;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.keystone.TokenCredential;

/**
 * Hello world!
 *
 */
public class Client 
{
	private String authUrl;
	private int timeout;
	private boolean debug;
	private boolean inSecure;
	
	public static final String USER_AGENT = "yunioncloud-java/201711";
	
	public Client(String authUrl, int timeout, boolean debug, boolean insecure) {
		this.authUrl = authUrl;
		this.timeout = timeout;
		this.debug = debug;
		this.inSecure = insecure;
	}
	
	private HttpURLConnection rawRequest(String endpoint, String token, String method, String url, HttpHeaders headers, InputStream body) throws Exception {
		method = method.toUpperCase();
		
		if (this.debug) {
			System.out.println(method + " " + endpoint + url);
		}
		URL requrl = new URL(endpoint + url);
		
		if (requrl.getProtocol().equals("https") && this.inSecure) {
            Utils.disableHttpsVerification();
        }

        HttpURLConnection req = (HttpURLConnection) requrl.openConnection();
		req.setRequestMethod(method);
        req.setRequestProperty("User-Agent", USER_AGENT);
        req.setInstanceFollowRedirects(false);
        req.setConnectTimeout(this.timeout*1000);
        req.setReadTimeout(this.timeout*1000);
        req.setUseCaches (false);
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
	        DataOutputStream wr = new DataOutputStream (req.getOutputStream ());
	        int rn = body.read(buffer);
	        while (rn != -1) {
	        		if (rn > 0) {
	        			wr.write(buffer, 0, rn);
	        		}
	        		rn = body.read(buffer);
	        }
	        wr.flush ();
	        wr.close ();
        }
        
        return req;
	}
	
	private String _inputStream2String(InputStream input) throws Exception {
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
	
	public JSONObject jsonRequest(String endpoint, String token, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
		return this.parseJSONResult(this._jsonRequest(endpoint, token, method, url, headers, jsonBody));
	}
	
	private HttpURLConnection _jsonRequest(String endpoint, String token, String method, String url, HttpHeaders headers, JSONObject jsonBody) throws Exception {
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
		headers.set("Content-Length", ""+ contlen);

		try {
			InputStream input = null;
			if (bodyStr != null) {
				input = new ByteArrayInputStream(bodyStr.getBytes(StandardCharsets.UTF_8.name()));
			}
			HttpURLConnection req = this.rawRequest(endpoint, token, method, url, headers, input);
			return req;
		} catch(Exception e) {
			e.printStackTrace();
			throw new JSONClientException(499, "", e.getMessage());
		}
	}
	
	private JSONObject parseJSONResult(HttpURLConnection req) throws Exception {
		int code = req.getResponseCode();
		req.getErrorStream();
		InputStream input = null;
		if (req.getResponseCode() >= 400) {
			input = req.getErrorStream();
		}else {
			input = req.getInputStream();
		}
		String textResult = null;
		JSONObject jsonResult = null;
		if (input != null) {
			textResult = _inputStream2String(input);
			if (this.debug) {
				System.out.println("Response code: " + code);
				System.out.println("Response: " + textResult);
			}
			try {
				jsonResult = new JSONObject(textResult);
			}catch(Exception e) {
				throw new JSONClientException(499, "Malformed JSON body", textResult);
			}
		} else {
			if (this.debug) {
				System.out.println("jsonRequest: no body");
			}
		}
		if (code >= 200 && code < 300) {
			return jsonResult;
		} else if (code >= 300 && code < 400) {
			throw new JSONClientException(code, "redirect", req.getHeaderField("Location"));
		}else  if (jsonResult != null) {
			if (jsonResult.has("error")) {
				JSONObject errBody = jsonResult.getJSONObject("error");
				if (errBody.has("message") && errBody.has("title") && errBody.has("code")) {
					throw new JSONClientException(errBody.getInt("code"), errBody.getString("title"), errBody.getString("message"));
				} else if (errBody.has("code") && errBody.has("details")) {
					String errCls = req.getResponseMessage();
					if (errBody.has("class")) {
						errCls = errBody.getString("class");
					}
					throw new JSONClientException(errBody.getInt("code"), errCls, errBody.getString("details"));
				} else {
					throw new JSONClientException(code, req.getResponseMessage(), errBody.toString());
				}
			} else {
				throw new JSONClientException(code, req.getResponseMessage(), jsonResult.toString());
			}
		}else if (textResult != null){
			throw new JSONClientException(code, req.getResponseMessage(), textResult);
		} else {
			throw new JSONClientException(code, req.getResponseMessage(), req.getResponseMessage());			
		}
	}
	
	private TokenCredential _auth(String domainName, String userName, String passwd, String projectId, String projectName, String token) throws Exception {
		JSONObject body = new JSONObject();
		if (userName != null && passwd != null && userName.length() > 0 && passwd.length() > 0) {
			Utils.JSONAdd(body, Utils.stringArray2JSONArray(new String[] {"password"}), "auth", "identity", "methods");
			Utils.JSONAdd(body, userName, "auth", "identity", "password", "user", "name");
			Utils.JSONAdd(body, passwd, "auth", "identity", "password", "user", "password");
			if (domainName != null && domainName.length() > 0) {
				Utils.JSONAdd(body, domainName, "auth", "identity", "password", "user", "domain", "name");
			} else {
				Utils.JSONAdd(body, "default", "auth", "identity", "password", "user", "domain", "id");				
			}
		} else if (token != null && token.length() > 0) {
	        Utils.JSONAdd(body, Utils.stringArray2JSONArray(new String[]{"token"}), "auth", "identity", "methods");
	        Utils.JSONAdd(body, token, "auth", "identity", "token", "id");
		}
		if (projectId != null && projectId.length() > 0) {
			Utils.JSONAdd(body, projectId, "auth", "scope", "project", "id");
		}
		if (projectName != null && projectName.length() > 0) {
			Utils.JSONAdd(body, "default", "auth", "scope", "project", "domain", "id");
			Utils.JSONAdd(body, projectName, "auth", "scope", "project", "name");
		}
		HttpURLConnection req = this._jsonRequest(this.authUrl, null, "POST", "/auth/tokens", null, body);
		String subjectId = req.getHeaderField("X-Subject-Token");
		if (subjectId == null || subjectId.length() == 0) {
			throw new Exception("Invalid token response from keystone");
		}
		TokenCredential cred = new TokenCredential(subjectId);
		JSONObject result = this.parseJSONResult(req);
		cred.parseJSON(result);
		return cred;
	}
	
	public TokenCredential Authenticate(String user, String passwd, String domain, String project) throws Exception {
		return this._auth(domain, user, passwd, null, project, null);
	}
	
	public TokenCredential SwitchProject(String projectId, String projectName, TokenCredential token) throws Exception {
		return this._auth(null, null, null, projectId, projectName, token.getToken());
	}
	
	public Session newSession(String region, String zone, String endpointType, TokenCredential token) {
		return new Session(this, region, zone, endpointType, token);
	}
}
