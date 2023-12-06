package com.yunionyun.mcp.mcclient.managers.impl.monitor;

public class MetricQueryModelTag {
	public static final String COND_AND = "and";
	public static final String COND_OR = "or";
	private String key;
	private String value;

	private String operator;

	private String condition;

	public MetricQueryModelTag(String key, String value, String operator) {
		this.key = key;
		this.value = value;
		this.operator = operator;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public static MetricQueryModelTag Equal(String key, String val) {
		return new MetricQueryModelTag(key, val, "=");
	}

	public static MetricQueryModelTag NotEqual(String key, String val) {
		return new MetricQueryModelTag(key, val, "!=");
	}

	public static MetricQueryModelTag LT(String key, String val) {
		return new MetricQueryModelTag(key, val, "<");
	}

	public static MetricQueryModelTag GT(String key, String val) {
		return new MetricQueryModelTag(key, val, ">");
	}

	public MetricQueryModelTag AND() {
		this.setCondition(COND_AND);
		return this;
	}

	public MetricQueryModelTag OR() {
		this.setCondition(COND_OR);
		return this;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public String getOperator() {
		return operator;
	}

	public String getCondition() {
		return condition;
	}
}
