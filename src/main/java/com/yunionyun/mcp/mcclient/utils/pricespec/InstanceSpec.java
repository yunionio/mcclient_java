package com.yunionyun.mcp.mcclient.utils.pricespec;

import java.util.ArrayList;

public class InstanceSpec {
	private String brand;
	private String region;
	private String zone;
	private String instanceType;
	private ArrayList<InstanceDiskSpec> disks;
	
	public InstanceSpec(String brand, String region, String zone, String instanceType, String diskType, int sizeGB) {
		this.brand = brand;
		this.region = region;
		this.zone = zone;
		this.instanceType = instanceType;
		this.disks = new ArrayList<InstanceDiskSpec>();
		this.addDisk(diskType, sizeGB);
	}
	
	public InstanceSpec addDisk(String diskType, int sizeGB) {
		this.disks.add(new InstanceDiskSpec(diskType, sizeGB));
		return this;
	}
	
	public ArrayList<ResourceSpec> getSpecs() {
		ArrayList<ResourceSpec> specs = new ArrayList<ResourceSpec>();
		specs.add(new CpuMemSpec(this.brand, this.region, this.zone, this.instanceType));
		for(int i = 0; i < this.disks.size(); i ++) {
			InstanceDiskSpec idisk = this.disks.get(i);
			specs.add(new DiskSpec(this.brand, this.region, this.zone, idisk.diskType, idisk.sizeGB));
		}
		return specs;
	}
}
