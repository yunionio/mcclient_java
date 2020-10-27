package com.yunionyun.mcp.mcclient.utils.pricespec;

public class DiskSpec extends BaseResourceSpec {
	public DiskSpec(String brand, String region, String zone, String resourceType, String diskType, int sizeGB) {
		super(brand, region, zone, resourceType, diskType, String.format("%dGB", sizeGB));
	}
}
