package com.yunionyun.mcp.mcclient.managers.impl;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.GlanceManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

public class ImageManager extends GlanceManager {

	public ImageManager() {
		this(EndpointType.InternalURL);
	}

	public ImageManager(EndpointType endpointType) {
		super("image", "images", endpointType,
				new String[]{"ID", "Name", "Tags", "Disk_format",
						"Size", "Is_public", "OS_Type",
						"OS_Distribution", "OS_version",
						"Min_disk", "Min_ram", "Status",
						"Notes", "OS_arch", "Preference",
						"OS_Codename", "Parent_id"},
				new String[]{"Owner", "Owner_name"});
	}
	
	public ListResult List(Session s, JSONObject query) throws McClientJavaBizException, IOException, JSONClientException {
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

}
