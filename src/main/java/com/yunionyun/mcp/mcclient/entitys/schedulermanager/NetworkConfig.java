package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class NetworkConfig {
	@JSONField(name = "index")
	private int index;

	@JSONField(name = "network")
	private String network;

	@JSONField(name = "wire")
	private String wire;

	@JSONField(name = "exit")
	private boolean exit;

	@JSONField(name = "private")
	private boolean privat;

	@JSONField(name = "mac")
	private String mac;

	@JSONField(name = "address")
	private String address;

	@JSONField(name = "address6")
	private String address6;

	@JSONField(name = "driver")
	private String driver;

	@JSONField(name = "bw_limit")
	private int bwLimit;

	@JSONField(name = "vip")
	private boolean vip;

	@JSONField(name = "reserved")
	private boolean reserved;

	@JSONField(name = "net_type")
	private String netType;

	@JSONField(name = "require_designated_ip")
	private boolean requireDesignatedIP;

	@JSONField(name = "require_teaming")
	private boolean requireTeaming;

	@JSONField(name = "try_teaming")
	private boolean tryTeaming;

	@JSONField(name = "standby_port_count")
	private int standbyPortCount;

	@JSONField(name = "standby_addr_count")
	private int standbyAddrCount;

	@JSONField(name = "project_id")
	private String project;

	@JSONField(name = "domain_id")
	private String domain;

	@JSONField(name = "ifname")
	private String ifname;

	@JSONField(name = "schedtags")
	private SchedtagConfig[] schedtags;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getWire() {
		return wire;
	}

	public void setWire(String wire) {
		this.wire = wire;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public boolean isPrivat() {
		return privat;
	}

	public void setPrivat(boolean privat) {
		this.privat = privat;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress6() {
		return address6;
	}

	public void setAddress6(String address6) {
		this.address6 = address6;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getBwLimit() {
		return bwLimit;
	}

	public void setBwLimit(int bwLimit) {
		this.bwLimit = bwLimit;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public boolean isRequireDesignatedIP() {
		return requireDesignatedIP;
	}

	public void setRequireDesignatedIP(boolean requireDesignatedIP) {
		this.requireDesignatedIP = requireDesignatedIP;
	}

	public boolean isRequireTeaming() {
		return requireTeaming;
	}

	public void setRequireTeaming(boolean requireTeaming) {
		this.requireTeaming = requireTeaming;
	}

	public boolean isTryTeaming() {
		return tryTeaming;
	}

	public void setTryTeaming(boolean tryTeaming) {
		this.tryTeaming = tryTeaming;
	}

	public int getStandbyPortCount() {
		return standbyPortCount;
	}

	public void setStandbyPortCount(int standbyPortCount) {
		this.standbyPortCount = standbyPortCount;
	}

	public int getStandbyAddrCount() {
		return standbyAddrCount;
	}

	public void setStandbyAddrCount(int standbyAddrCount) {
		this.standbyAddrCount = standbyAddrCount;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIfname() {
		return ifname;
	}

	public void setIfname(String ifname) {
		this.ifname = ifname;
	}

	public SchedtagConfig[] getSchedtags() {
		return schedtags;
	}

	public void setSchedtags(SchedtagConfig[] schedtags) {
		this.schedtags = schedtags;
	}
}
