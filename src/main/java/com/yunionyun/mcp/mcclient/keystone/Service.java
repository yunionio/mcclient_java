package com.yunionyun.mcp.mcclient.keystone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;

public class Service extends BaseResource {
	private String type;
	private Endpoint[] endpoints;
	
	public void parseJSON(JSONObject obj) {
		super.parseJSON(obj);
		type = obj.getString("type");
		JSONArray epArray = obj.getJSONArray("endpoints");
		endpoints = new Endpoint[epArray.size()];
		for (int i = 0; i < epArray.size(); i ++) {
			endpoints[i] = new Endpoint();
			endpoints[i].parseJSON(epArray.getJSONObject(i));
		}
	}

	public void addRegions(Set<String> regions) {
		for (int i = 0; i < this.endpoints.length; i ++) {
			String[] regionZone = this.endpoints[i].getRegionZone();
			regions.add(regionZone[0]);
		}
	}
	
	public String getType() {
		return this.type;
	}
	
	public String[] getServiceUrls(String region, String zone, EndpointType endpointType) {
		HashMap<String, HashSet<String>> urlTbl = new HashMap<String, HashSet<String>>();
		for (int i = 0; i < this.endpoints.length; i ++) {
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
		String[] candidates = new String[urls.size()];
		candidates = urls.toArray(candidates);
		return candidates;
	}
	
	public String getServiceUrl(String region, String zone, EndpointType endpointType) {
		String[] candidates = this.getServiceUrls(region, zone, endpointType);
		int randidx = (int)(Math.random()*candidates.length);
		return candidates[randidx];
	}
}
