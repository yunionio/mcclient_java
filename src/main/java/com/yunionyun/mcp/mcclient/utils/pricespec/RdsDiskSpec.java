package com.yunionyun.mcp.mcclient.utils.pricespec;

public class RdsDiskSpec {
	protected String resourceType;
	protected String diskType;
	protected int sizeGB;

	public RdsDiskSpec(String diskType, int sizeGB) {
		this.resourceType = "rds_storage";
		this.diskType = diskType;
		this.sizeGB = sizeGB;
	}
}
