package com.yunionyun.mcp.mcclient.managers;

import org.json.JSONObject;

import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.Utils;

public class ResourceManager extends BaseManager {
	protected String context;
	protected String keyword;
	protected String keywordPlural;
	
	public ResourceManager(String serviceType, String endpointType, String version, String[] columns, String[] adminColumns, String keyword, String keywordPlural, String context) {
		super(serviceType, endpointType, version, columns, adminColumns);
		this.context = context;
		this.keyword = keyword;
		this.keywordPlural = keywordPlural;
	}
	
	protected String urlKey() {
		return this.keywordPlural.replaceAll(":", "/");
	}
	
	protected StringBuilder getContextPath(ManagerContext[] ctx) {
		StringBuilder url = new StringBuilder();
		url.append("/");
		if (this.context != null && this.context.length() > 0) {
			url.append(this.context);
			if (!this.context.endsWith("/")) {
				url.append("/");
			}
		}
		if (ctx != null && ctx.length > 0) {
			for (int i = 0; i < ctx.length; i ++) {
				url.append(ctx[i].getContextKey());
				url.append("/");
				url.append(ctx[i].getId());
				url.append("/");
			}
		}
		return url;
	}
	
	public JSONObject Get(Session s, String id, JSONObject query, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._get(s, url.toString(), this.keyword);
	}
	
	public JSONObject Get(Session s, String id, JSONObject query, ManagerContext ctx) throws Exception {
		return this.Get(s, id, query, new ManagerContext[]{ctx});
	}
	
	public JSONObject Get(Session s, String id, JSONObject query) throws Exception {
		return this.Get(s, id, query, new ManagerContext[] {});
	}
	
	public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		url.append("/");
		url.append(spec);
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._get(s, url.toString(), this.keyword);
	}
	
	public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query, ManagerContext ctx) throws Exception {
		return this.GetSpecific(s, id, spec, query, new ManagerContext[] {ctx});
	}
	
	public JSONObject GetSpecific(Session s, String id, String spec, JSONObject query) throws Exception {
		return this.GetSpecific(s, id, spec, query, new ManagerContext[] {});
	}

	public ListResult List(Session s, JSONObject query, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		if (query != null) {
			String queryStr = Utils.JSONObject2QueryString(query);
			if (queryStr.length() > 0) {
				url.append("?");
				url.append(queryStr);
			}
		}
		return this._list(s, url.toString(), this.keywordPlural);
	}
	
	public ListResult List(Session s, JSONObject query, ManagerContext ctx) throws Exception {
		return this.List(s, query, new ManagerContext[] {ctx});
	}
	
	public ListResult List(Session s, JSONObject query) throws Exception {
		return this.List(s, query, new ManagerContext[] {});
	}
	
	public JSONObject Create(Session s, JSONObject params, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		return this._post(s, url.toString(), params, this.keyword);
	}

	public JSONObject Create(Session s, JSONObject params, ManagerContext ctx) throws Exception {
		return this.Create(s, params, new ManagerContext[] {ctx});
	}

	public JSONObject Create(Session s, JSONObject params) throws Exception {
		return this.Create(s, params, new ManagerContext[] {});
	}
	
	public JSONObject PerformAction(Session s, String id, String action, JSONObject params, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		url.append("/");
		url.append(action);
		return this._post(s, url.toString(), params, this.keyword);
	}

	public JSONObject PerformAction(Session s, String id, String action, JSONObject params, ManagerContext ctx) throws Exception {
		return this.PerformAction(s, id, action, params, new ManagerContext[] {ctx});
	}

	public JSONObject PerformAction(Session s, String id, String action, JSONObject params) throws Exception {
		return this.PerformAction(s, id, action, params, new ManagerContext[] {});
	}
	
	public JSONObject Update(Session s, String id, JSONObject params, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		return this._put(s, url.toString(), params, this.keyword);
	}

	public JSONObject Update(Session s, String id, JSONObject params, ManagerContext ctx) throws Exception {
		return this.Update(s, id, params, new ManagerContext[] {ctx});
	}

	public JSONObject Update(Session s, String id, JSONObject params) throws Exception {
		return this.Update(s, id, params, new ManagerContext[] {});
	}
	
	public JSONObject Patch(Session s, String id, JSONObject params, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		return this._patch(s, url.toString(), params, this.keyword);
	}

	public JSONObject Patch(Session s, String id, JSONObject params, ManagerContext ctx) throws Exception {
		return this.Patch(s, id, params, new ManagerContext[] {ctx});
	}

	public JSONObject Patch(Session s, String id, JSONObject params) throws Exception {
		return this.Patch(s, id, params, new ManagerContext[] {});
	}

	public JSONObject Delete(Session s, String id, ManagerContext[] ctx) throws Exception {
		StringBuilder url = this.getContextPath(ctx);
		url.append(this.urlKey());
		url.append("/");
		url.append(id);
		return this._delete(s, url.toString(), null, this.keyword);
	}

	public JSONObject Delete(Session s, String id, ManagerContext ctx) throws Exception {
		return this.Delete(s, id,new ManagerContext[] {ctx});
	}

	public JSONObject Delete(Session s, String id) throws Exception {
		return this.Delete(s, id, new ManagerContext[] {});
	}
}
