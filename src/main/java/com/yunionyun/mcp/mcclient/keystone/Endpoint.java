package com.yunionyun.mcp.mcclient.keystone;


import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;

public class Endpoint {
	String id;
	String type;
	String region;
	String regionId;
	String url;
	
	public void parseJSON(JSONObject obj) {
		id = obj.getString("id");
		type = obj.getString("interface");
		region = obj.getString("region");
		url = obj.getString("url");
		regionId = obj.getString("region_id");
	}
	
	public static String RegionID(String region, String zone) {
		if (zone != null && zone.length() > 0) {
			return region + "-" + zone;
		}else {
			return "" + region;
		}
	}
	
	public static String[] Id2RegionZone(String id) {
		int pos = id.indexOf("-");
		if (pos > 0) {
			return new String[] {id.substring(0, pos), id.substring(pos+1)};
		} else {
			return new String[] {"" + id, null};
		}
	}
	
	public String[] getRegionZone() {
		return Id2RegionZone(this.regionId);
	}
	
	public boolean isType(EndpointType type) {
		if (type.toString().toLowerCase().startsWith(this.type.toLowerCase())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getRegion() {
		return this.regionId;
	}
	
	public boolean inRegion(String region, String zone) {
		if (region == null || this.regionId.equals(region) || this.regionId.equals(RegionID(region, zone))) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getUrl() {
		return this.url;
	}
}
