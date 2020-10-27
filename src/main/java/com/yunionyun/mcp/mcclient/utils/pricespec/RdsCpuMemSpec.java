package com.yunionyun.mcp.mcclient.utils.pricespec;

public class RdsCpuMemSpec extends BaseResourceSpec {
	public RdsCpuMemSpec(String brand, String region, String zone, String rdsType) {
		super(brand, region, zone, "rds", rdsType, null);
	}
}