package com.yunionyun.mcp.mcclient.keystone;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Service extends BaseResource {
	private String type;
	private Endpoint[] endpoints;

	public void parseJSON(JSONObject obj) {
		super.parseJSON(obj);
		type = obj.getString("type");
		JSONArray epArray = obj.getJSONArray("endpoints");
		endpoints = new Endpoint[epArray.size()];
		for (int i = 0; i < epArray.size(); i++) {
			endpoints[i] = new Endpoint();
			endpoints[i].parseJSON(epArray.getJSONObject(i));
		}
	}

	public void addRegions(Set<String> regions) {
		for (int i = 0; i < this.endpoints.length; i++) {
			String[] regionZone = this.endpoints[i].getRegionZone();
			regions.add(regionZone[0]);
		}
	}

	public String getType() {
		return this.type;
	}

	public String[] getServiceUrls(String region, String zone, EndpointType endpointType)
			throws McClientJavaBizException {
		HashMap<String, HashSet<String>> urlTbl = new HashMap<String, HashSet<String>>();
		for (int i = 0; i < this.endpoints.length; i++) {
			if (this.endpoints[i].isType(endpointType)) {
				if (this.endpoints[i].inRegion(region, zone)) {
					String curRegion = this.endpoints[i].getRegion();
					String url = this.endpoints[i].getUrl();
					if (!urlTbl.containsKey(curRegion)) {
						urlTbl.put(curRegion, new HashSet<String>());
					}
					urlTbl.get(curRegion).add(url);
				}
			}
		}
		HashSet<String> urls = null;
		if (region == null || region.length() == 0) {
			if (urlTbl.size() > 1) {
				throw new McClientJavaBizException("region must be specified!");
			} else {
				urls = urlTbl.get(urlTbl.keySet().toArray(new String[1])[0]);
			}
		} else if (urlTbl.containsKey(Endpoint.RegionID(region, zone))) {
			urls = urlTbl.get(Endpoint.RegionID(region, zone));
		} else if (urlTbl.containsKey(region)) {
			urls = urlTbl.get(region);
		}
		// 可能存在urls为null的情况：服务端目录列表中没有对应的url与配置文件中传入的url进行匹配
		if (urls != null) {
			String[] candidates = new String[urls.size()];
			candidates = urls.toArray(candidates);
			return candidates;
		} else {
			return new String[0];
		}
	}

	public String getServiceUrl(String region, String zone, EndpointType endpointType)
			throws McClientJavaBizException {
		String[] candidates = this.getServiceUrls(region, zone, endpointType);
		int randidx = (int) (Math.random() * candidates.length);
		if (candidates.length != 0) {
			return candidates[randidx];
		} else {
			// 此种情况是服务端目录列表中没有对应的url与配置文件中传入的url进行匹配
			throw new McClientJavaBizException("服务端目录列表中没有" + this.type + "对应的url");
		}
	}
}
