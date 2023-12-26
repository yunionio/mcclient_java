package com.yunionyun.mcp.mcclient.managers.impl.monitor;

import java.util.ArrayList;
import java.util.List;

public class MetricQueryPart {
	public static final String TYPE_FIELD = "field";
	public static final String TYPE_MEAN = "mean";
	public static final String TYPE_ALIAS = "alias";
	public static final String TYPE_TAG = "tag";

	private String type;
	private List<String> params;

	private MetricQueryPart(String type) {
		this.type = type;
	}

	public MetricQueryPart(String type, String val) {
		List<String> params = new ArrayList<>();
		params.add(val);
		this.type = type;
		this.params = params;
	}

	public MetricQueryPart(String type, List<String> params) {
		this.type = type;
		this.params = params;
	}

	public static MetricQueryPart newField(String field) {
		return new MetricQueryPart(TYPE_FIELD, field);
	}

	public static MetricQueryPart MEAN() {
		return new MetricQueryPart(TYPE_MEAN);
	}

	public static MetricQueryPart ALIAS(String alias) {
		return new MetricQueryPart(TYPE_ALIAS, alias);
	}

	public String getType() {
		return type;
	}

	public List<String> getParams() {
		return params;
	}
}
