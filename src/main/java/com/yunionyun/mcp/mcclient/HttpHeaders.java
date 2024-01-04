package com.yunionyun.mcp.mcclient;

import java.net.HttpURLConnection;
import java.util.HashMap;

public class HttpHeaders {
	private HashMap<String, String> _headers;

	public HttpHeaders() {
		_headers = new HashMap<String, String>();
	}

	public void set(String key, String value) {
		key = normalizeKey(key);
		_headers.put(key, value);
	}

	public String get(String key) {
		key = normalizeKey(key);
		return _headers.get(key);
	}

	public boolean has(String key) {
		key = normalizeKey(key);
		return _headers.containsKey(key);
	}

	public void update(HttpHeaders hdr) {
		for (String key : hdr._headers.keySet()) {
			this.set(key, hdr.get(key));
		}
	}

	public void remove(String key) {
		if (_headers.containsKey(key)) {
			_headers.remove(key);
		}
	}

	private String normalizeKey(String key) {
		String[] segs = key.split("-");
		for (int i = 0; i < segs.length; i++) {
			segs[i] = segs[i].substring(0, 1).toUpperCase() + segs[i].substring(1).toLowerCase();
		}
		return String.join("-", segs);
	}

	public void setHeaders(HttpURLConnection req) {
		for (String k : _headers.keySet()) {
			req.setRequestProperty(k, _headers.get(k));
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String key : _headers.keySet()) {
			builder.append(key);
			builder.append(": ");
			builder.append(_headers.get(key));
			builder.append("\n");
		}
		return builder.toString();
	}
}
