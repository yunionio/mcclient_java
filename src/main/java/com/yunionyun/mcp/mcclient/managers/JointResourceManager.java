package com.yunionyun.mcp.mcclient.managers;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

import java.io.IOException;

public class JointResourceManager extends ResourceManager {
	private ResourceManager master;
	private ResourceManager slave;

	public JointResourceManager(
			String serviceType,
			String apiVersion,
			EndpointType endpointType,
			String version,
			String[] columns,
			String[] adminColumns,
			String keyword,
			String keywordPlural,
			String context,
			ResourceManager master,
			ResourceManager slave) {
		super(serviceType, apiVersion, endpointType, version, columns, adminColumns, keyword, keywordPlural, context);
		this.master = master;
		this.slave = slave;
	}

	public JSONObject Get(Session s, String mid, String sid, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		url.append("/");
		url.append(sid);
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._get(s, url.toString(), this.keyword);
	}

	public ListResult LisDescendent(Session s, String mid, JSONObject query)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._list(s, url.toString(), this.keywordPlural);
	}

	public JSONObject Attach(Session s, String mid, String sid, JSONObject params)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		url.append("/");
		url.append(sid);
		url.append(this.urlKey());
		return this._post(s, url.toString(), params, this.keyword);
	}

	public JSONObject Detach(Session s, String mid, String sid)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		url.append("/");
		url.append(sid);
		url.append(this.urlKey());
		return this._delete(s, url.toString(), null, this.keyword);
	}

	public JSONObject Update(Session s, String mid, String sid, JSONObject params)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		url.append("/");
		url.append(sid);
		url.append(this.urlKey());
		return this._put(s, url.toString(), params, this.keyword);
	}

	public JSONObject Patch(Session s, String mid, String sid, JSONObject params)
			throws McClientJavaBizException, IOException, JSONClientException {
		StringBuilder url = this.getContextPath(null);
		url.append(this.master.urlKey());
		url.append("/");
		url.append(mid);
		url.append("/");
		url.append(this.slave.urlKey());
		url.append("/");
		url.append(sid);
		url.append(this.urlKey());
		return this._patch(s, url.toString(), params, this.keyword);
	}
}
