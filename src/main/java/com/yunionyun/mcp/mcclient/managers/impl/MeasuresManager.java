package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONArray;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.managers.GnocchiManager;

/**
 * @author zxc for OpenStack
 * @date 2020/03/17
 */
public class MeasuresManager extends GnocchiManager {
	public MeasuresManager() {
		this(EndpointType.AdminURL);
	}

	public MeasuresManager(EndpointType endpointType) {
		super("", "", endpointType, new String[0], new String[]{"switch_port", "volume_provider_pool", "Domain_Id", "Enabled", "Email", "Mobile"});
	}

	public JSONArray listResourceMetric(Session session, String resourceId, String metric, String start) throws Exception {
		String url = "/v1/resource/generic/" + resourceId + "/metric/" + metric + "/measures";
		if (start != null && !"".equals(start)) {
			url = url + "?start=" + start;
		}

		return this._listRaw(session, url);
	}

	public JSONArray listResource(Session session, String subType) {
		try {
			String url = "/v1/resource/";
			if (subType != null && !"".equals(subType)) {
				url = url + subType;
				JSONArray resp = this._listRaw(session, url);
				return resp;
			}
		} catch (Exception var5) {
			var5.printStackTrace();
		}

		return null;
	}

	public JSONArray listMetric(Session session) {
		try {
			String url = "/v1/metric";
			return this._listRaw(session, url);
		} catch (Exception var3) {
			var3.printStackTrace();
			return null;
		}
	}


}
