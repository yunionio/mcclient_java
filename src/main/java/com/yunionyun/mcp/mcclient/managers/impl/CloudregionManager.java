package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.ComputeManager;
import com.yunionyun.mcp.mcclient.managers.ListResult;

import java.io.IOException;
import java.util.*;

public class CloudregionManager extends ComputeManager {
	private static final Integer LIMIT_SIZE = 2048;

	public CloudregionManager() {
		this(EndpointType.InternalURL);
	}

	public CloudregionManager(EndpointType endpointType) {
		super(
				"cloudregion",
				"cloudregions",
				endpointType,
				new String[]{"ID", "Name", "Enabled", "Status", "Provider", "Latitude", "Longitude"},
				new String[]{});
	}

	public JSONArray getRegionCities(Session session, JSONObject params)
			throws JSONClientException, McClientJavaBizException, IOException {
		return getRegionAttributeList(session, params, "city");
	}

	public JSONArray getRegionProviders(Session session, JSONObject params)
			throws JSONClientException, McClientJavaBizException, IOException {
		return getRegionAttributeList(session, params, "provider");
	}

	private JSONArray getRegionAttributeList(Session session, JSONObject params, String attr)
			throws JSONClientException, McClientJavaBizException, IOException {
		List<NameCounter> nameCounters = new ArrayList<NameCounter>();
		Map<String, Integer> cities = new HashMap<String, Integer>();

		if (!params.containsKey("limit") || params.getIntValue("limit") == 0) {
			params.put("limit", LIMIT_SIZE);
		}
		ListResult listResult = this.List(session, params);
		if (listResult != null && listResult.getDataSize() > 0) {
			for (int i = 0; i < listResult.getDataSize(); i++) {
				String cityStr = listResult.getDataAt(i).getString(attr);
				if (cityStr == null || cityStr.length() == 0) {
					cityStr = "Other";
				} else {
					if (cities.containsKey(cityStr)) {
						cities.put(cityStr, cities.get(cityStr) + 1);
						continue;
					}
					cities.put(cityStr, 1);
				}
			}
		}
		if (cities.size() > 0) {
			for (Map.Entry<String, Integer> entry : cities.entrySet()) {
				nameCounters.add(new NameCounter(entry.getKey(), entry.getValue()));
			}
		}
		if (nameCounters.size() > 0) {
			Collections.sort(nameCounters, new SortByCount());
		}
		return JSONObject.parseArray(JSONObject.toJSONString(nameCounters));
	}

	class NameCounter {
		private String name;
		private int count;

		public NameCounter(String name, int count) {
			this.name = name;
			this.count = count;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}

	class SortByCount implements Comparator<NameCounter> {
		public int compare(NameCounter o1, NameCounter o2) {
			if (o1.getCount() < o2.getCount()) {
				return 1;
			} else if (o1.getCount() == o2.getCount()) {
				return 0;
			}
			return -1;
		}
	}
}
