package com.yunionyun.mcp.mcclient.utils.pricespec;

import java.util.ArrayList;

public class BaseResourceSpec implements ResourceSpec {
	private String brand;
	private String region;
	private String zone;
	private String resourceType;
	private String resourceSpec;
	private String quantity;
	
	public BaseResourceSpec(String brand, String region, String zone, String resourceType, String resourceSpec, String quantity) {
		this.brand = brand;
		this.region = region;
		this.zone = zone;
		this.resourceType = resourceType;
		this.resourceSpec = resourceSpec;
		this.quantity = quantity;
	}
	
	private String getRegion() {
		if (this.region == null) {
			return "";
		}else {
			return this.region;
		}
	}
	
	private String getZone() {
		if (this.zone == null) {
			return "";
		}else {
			return this.zone;
		}
	}
	
	public String GetPriceKey() {
		ArrayList<String> vals = new ArrayList<String>();
		vals.add(this.brand);
		vals.add(this.getRegion());
		vals.add(this.getZone());
		vals.add(this.resourceType);
		vals.add(this.resourceSpec);
		if (this.quantity != null && this.quantity.length() > 0) {
			vals.add(this.quantity);
		}
		return String.join("::", vals);
	}
}
