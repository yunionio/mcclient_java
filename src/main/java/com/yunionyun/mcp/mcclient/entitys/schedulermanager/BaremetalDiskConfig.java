package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class BaremetalDiskConfig {
	@JSONField(name = "type")
	private String type;

	@JSONField(name = "conf")
	private String conf;

	@JSONField(name = "count")
	private long count;

	@JSONField(name = "range")
	private long[] range;

	@JSONField(name = "splits")
	private String splits;

	@JSONField(name = "size")
	private long[] size;

	@JSONField(name = "adapter")
	private Integer adapter;

	@JSONField(name = "driver")
	private String driver;

	@JSONField(name = "cachedbadbbu")
	private Boolean cachedbadbbu;

	@JSONField(name = "strip")
	private Long[] strip;

	@JSONField(name = "ra")
	private Boolean ra;

	@JSONField(name = "wt")
	private Boolean wt;

	@JSONField(name = "direct")
	private Boolean direct;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long[] getRange() {
		return range;
	}

	public void setRange(long[] range) {
		this.range = range;
	}

	public String getSplits() {
		return splits;
	}

	public void setSplits(String splits) {
		this.splits = splits;
	}

	public long[] getSize() {
		return size;
	}

	public void setSize(long[] size) {
		this.size = size;
	}

	public Integer getAdapter() {
		return adapter;
	}

	public void setAdapter(Integer adapter) {
		this.adapter = adapter;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Boolean getCachedbadbbu() {
		return cachedbadbbu;
	}

	public void setCachedbadbbu(Boolean cachedbadbbu) {
		this.cachedbadbbu = cachedbadbbu;
	}

	public Long[] getStrip() {
		return strip;
	}

	public void setStrip(Long[] strip) {
		this.strip = strip;
	}

	public Boolean getRa() {
		return ra;
	}

	public void setRa(Boolean ra) {
		this.ra = ra;
	}

	public Boolean getWt() {
		return wt;
	}

	public void setWt(Boolean wt) {
		this.wt = wt;
	}

	public Boolean getDirect() {
		return direct;
	}

	public void setDirect(Boolean direct) {
		this.direct = direct;
	}
}
