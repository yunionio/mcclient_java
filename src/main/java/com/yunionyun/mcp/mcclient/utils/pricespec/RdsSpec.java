package com.yunionyun.mcp.mcclient.utils.pricespec;

import java.util.ArrayList;

public class RdsSpec {
	private String brand;
	private String region;
	private String zone;
	private String rdsType;
	private ArrayList<RdsDiskSpec> disks;

	public RdsSpec(String brand, String region, String zone, String rdsType, String diskType, int sizeGB) {
		this.brand = brand;
		this.region = region;
		this.zone = zone;
		this.rdsType = rdsType;
		this.disks = new ArrayList<RdsDiskSpec>();
		this.addDisk(diskType, sizeGB);
	}

	public RdsSpec addDisk(String diskType, int sizeGB) {
		this.disks.add(new RdsDiskSpec(diskType, sizeGB));
		return this;
	}

	public ArrayList<ResourceSpec> getSpecs() {
		ArrayList<ResourceSpec> specs = new ArrayList<ResourceSpec>();
		specs.add(new RdsCpuMemSpec(this.brand, this.region, this.zone, this.rdsType));
		for (int i = 0; i < this.disks.size(); i++) {
			RdsDiskSpec idisk = this.disks.get(i);
			specs.add(
					new DiskSpec(this.brand, this.region, this.zone, idisk.resourceType, idisk.diskType, idisk.sizeGB));
		}
		return specs;
	}
}
