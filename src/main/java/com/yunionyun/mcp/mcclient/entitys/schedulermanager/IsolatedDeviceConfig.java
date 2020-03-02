package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class IsolatedDeviceConfig {
	@JSONField(name = "index")
	private int index;

	@JSONField(name = "id")
	private String id;

	@JSONField(name = "dev_type")
	private String devType;

	@JSONField(name = "model")
	private String model;

	@JSONField(name = "vendor")
	private String vendor;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDevType() {
		return devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
