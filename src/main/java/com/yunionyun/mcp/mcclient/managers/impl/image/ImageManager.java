package com.yunionyun.mcp.mcclient.managers.impl.image;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.HttpHeaders;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.GlanceManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;
import com.yunionyun.mcp.mcclient.utils.StringUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImageManager extends GlanceManager {

	static String IMAGE_META = "X-Image-Meta-";
	static String IMAGE_META_PROPERTY = "X-Image-Meta-Property-";

	static String IMAGE_METADATA = "X-Image-Meta-Metadata";
	static String IMAGE_PROJECT_METADATA = "X-Image-Meta-Project_metadata";

	public ImageManager() {
		this(EndpointType.InternalURL);
	}

	public ImageManager(EndpointType endpointType) {
		super(
				"image",
				"images",
				endpointType,
				new String[]{
						"ID",
						"Name",
						"Tags",
						"Disk_format",
						"Size",
						"Is_public",
						"OS_Type",
						"OS_Distribution",
						"OS_version",
						"Min_disk",
						"Min_ram",
						"Status",
						"Notes",
						"OS_arch",
						"Preference",
						"OS_Codename",
						"Parent_id"
				},
				new String[]{"Owner", "Owner_name"});
	}

	public ListResult List(Session s, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.urlKey());
		if (query != null) {
			if (query.containsKey("details") && query.getBoolean("details")) {
				url.append("/detail");
				query.remove("detail");
			}
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr != null && queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._list(s, url.toString(), this.keywordPlural);
	}

	public JSONObject Get(Session s, String id, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		return this.GetById(s, id, query);
	}

	public JSONObject GetById(Session s, String id, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		JSONObject result = new JSONObject();
		JSONObject properties = new JSONObject();
		HttpURLConnection resp = this._head(s, url.toString());
		Map<String, List<String>> header = resp.getHeaderFields();
		Set<String> hdrKeys = header.keySet();
		for (String k : hdrKeys) {
			if (k == null) {
				continue;
			}
			List<String> v = header.get(k);
			if (k == IMAGE_METADATA && v.size() == 1) {
				JSONObject metadata = JSONObject.parseObject(v.get(0));
				result.put("metadata", metadata);
			} else if (k == IMAGE_PROJECT_METADATA && v.size() == 1) {
				JSONObject metadata = JSONObject.parseObject(v.get(0));
				result.put("project_metadata", metadata);
			} else if (k.startsWith(IMAGE_META_PROPERTY)) {
				k = k.substring(IMAGE_META_PROPERTY.length()).toLowerCase();
				properties.put(k, v.get(0));
			} else if (k.startsWith(IMAGE_META)) {
				k = k.substring(IMAGE_META.length()).toLowerCase();;
				result.put(k, v.get(0));
			}
		}
		if (properties.size() > 0) {
			result.put("properties", new JSONObject());
		}
		return result;
	}

	public JSONObject Update(Session s, String id, JSONObject params)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = new StringBuilder();
		url.append("/");
		url.append(this.urlKey());
		url.append("/");
		url.append(id);

		HttpHeaders header = new HttpHeaders();
		for (String key : params.keySet()) {
			if (key == "copy_from" || key == "properties" || key == "compress_format") {
				continue;
			}
			Object value = params.getString(key);
			header.set("X-Image-Meta-"+StringUtils.CapitalizeString(key), value.toString());
		}
		JSONObject properties = params.getJSONObject("properties");
		if (properties != null) {
			for (String key : properties.keySet()) {
				Object value = properties.getString(key);
				header.set("X-Image-Meta-Property-"+StringUtils.CapitalizeString(key), value.toString());
			}
		}

		JSONObject respBody = this.jsonRequest(s, "PUT", url.toString(), header, null);
		return respBody.getJSONObject(this.keyword);
	}
}
