package com.yunionyun.mcp.mcclient.utils.pricespec;

public class CpuMemSpec extends BaseResourceSpec {
	public CpuMemSpec(String brand, String region, String zone, String instanceType) {
		super(brand, region, zone, "instance", instanceType, null);
	}
}
