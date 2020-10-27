package com.yunionyun.mcp.mcclient.utils.pricespec;

import java.util.ArrayList;

public class RedisSpec extends BaseResourceSpec {
	public RedisSpec(String brand, String region, String zone, String redisType) {
		super(brand, region, zone, "cache", redisType, null);
	}

	public ArrayList<ResourceSpec> getSpecs() {
		ArrayList<ResourceSpec> specs = new ArrayList<ResourceSpec>();
		specs.add(this);
		return specs;
	}
}
